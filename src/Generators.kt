import kotlinx.coroutines.*

fun main(args: Array<String>) {
    var powerOfTwo:Sequence<Int> = sequence{
        var currentNumber=1
        while (true){
            yield(currentNumber)
            currentNumber=2*currentNumber
        }
    }


    for ((index,num) in powerOfTwo.withIndex()){
        if(index === 10)
            break
        else
            println(num)
    }
}