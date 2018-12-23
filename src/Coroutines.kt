
import client.HttpClient
import client.HttpMethod
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import exceptions.CoreException
import javafx.application.Application.launch
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.*



suspend fun main(args: Array<String>) {

    runBlocking<Unit> {
        launch {
            val productIDs= listOf<String>("1","2","3")
            val promises= mutableListOf<Deferred<String?>>()
            val products=mutableListOf<String?>()
            productIDs.forEach {
                val service="https://services.odata.org/Northwind/Northwind.svc/Products($it)";
                val promise=async { getProduct(service) }
                promises.add(promise)

            }
            promises.forEach{products.add(it.await())}
            products.forEach{ println(it)}
        }
    }


}
suspend fun getProduct(url:String):String?{
    val startTime=System.currentTimeMillis()
    val httpClient = HttpClient()
    var jsonResponse = ""
    val queryParams = HashMap<String, String>()
    queryParams.put("\$format", "json")
    try {
        jsonResponse = httpClient.request(url, HttpMethod.GET,
                mutableMapOf<String,String>(), queryParams, null)
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jp = JsonParser()
        val je = jp.parse(jsonResponse)
        val prettyJsonString = gson.toJson(je)
        val endTime=System.currentTimeMillis()
        println("time elapsed is ${endTime-startTime}")
        return prettyJsonString
    } catch (e: CoreException) {
        e.printStackTrace()
        return null;
    }
}
