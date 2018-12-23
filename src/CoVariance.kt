interface Fruit {
  fun name(): String
}

 class Orange() : Fruit {
  override fun name(): String {
      return "Orange"
  }
}

open class Apple() : Fruit {
    override fun name(): String {
        return "Apple"
    }
}

class McIntosh() : Apple() {
    override fun name(): String {
        return "McIntosh"
    }
}

class Gala() : Apple() {
    override fun name(): String {
        return "Gala"
    }
}


 class Basket<out T>(val name:String="AppleBasket") {

}
//accepts Basket[Apple] or its subclasses
//since McIntosh is a subclass of Apple ,Basket[McIntosh] is a subclass of Basket[Apple]
fun basketDetails(basket: Basket<Apple>) {
    println("this is a ${basket.name}")
}
fun main(args: Array<String>) {
    val appleBasket = Basket<Apple>()
    val mcIntoshBasket = Basket<McIntosh>()
    val orangeBasket = Basket<Orange>()
    basketDetails(appleBasket)
    basketDetails(mcIntoshBasket)
    //basketDetails(orangeBasket) not allowed



}