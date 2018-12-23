import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun expensiveComputation(res: MutableList<String>) {
    delay(1000L)
    res.add("word!")
}

suspend fun getFirstName():String{
    delay(1000L)
    return "Sameer"
}

suspend fun getLastName():String{
    delay(1500L)
    return "Sarmah"
}

fun main(args: Array<String>) {
    val res = mutableListOf<String>()

    // when
    runBlocking<Unit> {
        val promise = launch {
            expensiveComputation(res)
        }
        val firstName=async {
            getFirstName()
        }
        val lastName=async {
            getLastName()
        }
        res.add("Hello,")
        promise.join()
        firstName.await()
        lastName.await()
        println("${firstName.await()} ${lastName.await()}")

        println(res)
    }
}