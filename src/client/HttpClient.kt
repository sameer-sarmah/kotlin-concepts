package client;

import exceptions.CoreException
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import org.apache.log4j.Logger
import java.io.IOException
import java.net.MalformedURLException

class HttpClient {


   fun request(url:String , method:HttpMethod ,headers:MutableMap<String,String>?,
                queryParams: MutableMap<String,String>?,jsonString: String? ):String{
       val logger  = Logger.getLogger("HttpClient")
        try {
           val requestBuilder: RequestBuilder = RequestBuilder.create(method.toString());

            headers.let {
                headers?.forEach({key,value ->
                    requestBuilder.addHeader(key,value)
                })
            }
            queryParams.let {
                queryParams?.forEach({key, value ->
                    val pair =BasicNameValuePair(key, value)
                    requestBuilder.addParameters(pair)
                })
            }

            requestBuilder.setUri(url);


            if(method.equals(HttpMethod.POST) || method.equals(HttpMethod.PUT)){
                val input =  StringEntity(jsonString);
                input.setContentType("application/json");
                requestBuilder.setEntity(input);
            }

            val request=requestBuilder.build();
            val client = HttpClientBuilder.create().build();
            val response = client.execute(request);



            return  EntityUtils.toString(response.getEntity());


        } catch (exception:MalformedURLException) {
            logger.error(exception.message);
            throw CoreException(exception?. message ?:"malformed url",500);

        } catch (exception:IOException) {
            logger.error(exception.message);
            throw  CoreException(exception?. message ?: "IO exception",500);
        }

    }
}
