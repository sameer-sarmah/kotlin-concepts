
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
    val service="https://services.odata.org/Northwind/Northwind.svc/Products";
//    val prettyJsonString=getProduct(service)
//
//    println(prettyJsonString)

}
//fun getProductByID(id:String):CompletableFuture<String>?{
//    val httpClient = HttpClient()
//    var jsonResponse = ""
//    val queryParams = HashMap<String, String>()
//    queryParams.put("\$format", "json")
//    try {
//        val url="https://services.odata.org/Northwind/Northwind.svc/Products/($id)";
//        jsonResponse = httpClient.request(url, HttpMethod.GET,
//            mutableMapOf<String,String>(), queryParams, null)
//        val gson = GsonBuilder().setPrettyPrinting().create()
//        val jp = JsonParser()
//        val je = jp.parse(jsonResponse)
//        val prettyJsonString = gson.toJson(je)
//        val future=CompletableFuture.
//        return prettyJsonString
//    } catch (e: CoreException) {
//        e.printStackTrace()
//        return null;
//    }
//}
