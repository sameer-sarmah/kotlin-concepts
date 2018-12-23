class AppleBasket<T : Apple>(){
     val xs= mutableListOf<T>()
     fun add(apple: T):Unit{
         xs.add(apple)
     }
}


fun main(args: Array<String>) {
    val mcIntoshBasket= AppleBasket<McIntosh>()
    mcIntoshBasket.add(McIntosh())
}