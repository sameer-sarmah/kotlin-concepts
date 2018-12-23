
 class FruitBasket<in T>(val name:String="FruitBasket") {
}

 // accepts FruitBasket[McIntosh] or its subclass
 //since Apple is a superclass of McIntosh ,due to contravariance Basket[Apple] is a subclass Basket[McIntosh]
 fun basketDetails(basket: FruitBasket<McIntosh>) {
     println("this is a ${basket.name}")
 }

 fun main(args: Array<String>) {
     val objectBasket = FruitBasket<Any>()
     val appleBasket = FruitBasket<Apple>()
     val mcIntoshBasket = FruitBasket<McIntosh>()
     val orangeBasket = FruitBasket<Orange>()
     basketDetails(appleBasket)
     basketDetails(mcIntoshBasket)
     basketDetails(objectBasket)

     //basketDetails(orangeBasket) not allowed



 }