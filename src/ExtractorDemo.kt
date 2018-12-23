fun main(args: Array<String>) {
    var instance=Extractor(1,"one")
    println(instance)
    val extractor=instance as Extractor
    val (intValue,strValue)=extractor
    println("${intValue}  ${strValue}")
}

data class Extractor(val intValue:Int, val strValue:String){}

