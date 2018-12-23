
import client.HttpClient
import client.HttpMethod
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import exceptions.CoreException
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future


fun main(args: Array<String>) {
    val productIDs= listOf<String>("1","2","3")
    val promises= mutableListOf<CompletableFuture<String>>()
    productIDs.forEach { promises.add(getProductByIDAsync(it)) }
    promises.forEach{promise->
        promise.thenAccept({println(it)})
    }

    Thread.sleep(10000)
}

fun getProductByIDAsync(id:String):CompletableFuture<String>{
    val completableFuture = CompletableFuture<String>()

    Executors.newCachedThreadPool().submit<Any> {
        val product=getProductByID(id)
        completableFuture.complete(product)
    }

    return completableFuture
}

fun getProductByID(id:String):String?{
    val httpClient = HttpClient()
    var jsonResponse = ""
    val queryParams = HashMap<String, String>()
    queryParams.put("\$format", "json")
    try {
        val url="https://services.odata.org/Northwind/Northwind.svc/Products($id)";
        jsonResponse = httpClient.request(url, HttpMethod.GET,
            mutableMapOf<String,String>(), queryParams, null)
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jp = JsonParser()
        val je = jp.parse(jsonResponse)
        val prettyJsonString = gson.toJson(je)
        return prettyJsonString;
    } catch (e: CoreException) {
        e.printStackTrace()
        return null;
    }
}
