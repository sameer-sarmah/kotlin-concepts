import java.util.*

fun main(args: Array<String>) {
    var collection = 1 to 10
    var evenNumberCalFunc:(Int) -> Boolean ={ num: Int -> (num % 2 == 0)}
    var (even, odd) = collection.toList().partition { (it % 2 == 0) }
    println(even)
    println(odd)

    var squareNumbers = { num: Int -> num * num}

    var squaredNum = listOf<Int>(5).map(squareNumbers)
    println(squaredNum)

    var numbers = (1 to 10).toList()
    var evenNumbers = numbers.filter(evenNumberCalFunc)
    println(evenNumbers)

    var transformedList = numbers.map(squareNumbers)
    println(transformedList)


    println(numbers.find({it == 5}))




    var tuple = Triple(1, 2, 3)
    println(tuple)
    val (one, two, three) = tuple
    println(one)
    println(tuple.second)

    var mutableSet = mutableSetOf<String>("val")
    mutableSet.add("abc")
    println("mutable set " + mutableSet)


    var immutableSet = setOf<String>("val")
    immutableSet.plus(mutableSet)


    var map = mutableMapOf<String,String>("India" to "Delhi")
    map.put ("Thailand" , "Bangkok")
    println(map)

    var sumFunc = {num1: Int, num2: Int ->
        println("numbers are $num1  &  $num2")
        num1 + num2
    }

    //limitation of reduce is that both the argument of the function passed should be same as well as the return type of the function
    numbers.reduceRight(sumFunc) //reads numbers from the right,i.e index size-1
    println("reduce ")
    numbers.reduce(sumFunc) //order could be random

    var concatFunc = {str1: String, str2: Int ->
        println("strings are $str1 and $str2")
        str1 + str2
    }

    numbers.fold("",concatFunc)

    println("fold right ")
    numbers.foldRight(""){str1: Int, str2: String ->
        println("strings are $str1 and $str2")
        str1.toString() + str2
    } //reads numbers from the right,i.e index size-1

}