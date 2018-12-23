
fun main(args: Array<String>) {
    var outerFunc={errorCode:Int,exception:String ->

        val desp="Error encountered while processing request"
        var innerFunct={
        Triple(errorCode,exception,desp)
        }
        innerFunct
    }
    var funcRef=outerFunc.invoke(404, "UnauthorisedException")
    var tuple=funcRef.invoke()
    println(tuple)
    val (errorCode,exception,desp)=tuple
    val ten=10
    fun add10(num:Int){
        num+ten
    }
    println(add10(4))
}