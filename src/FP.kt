fun main(args: Array<String>) {

    println("scurring using closure example,return a function")
    var scurryExmple = { num: Int ->
        val mulFactor = { mul: Int -> num * mul }
        mulFactor
    }
    println(scurryExmple(5)(4))

    fun saySomething(prefix: String): (String) -> String {
        val lambda = { name: String ->
            prefix + " " + name
        }
        return lambda
    }

    var hellFunc = saySomething("Hello");
    println(hellFunc("sameer"))


    println("function as argument")
    var mulFunction = { num1: Int, num2: Int, mul: (Int, Int) -> Int ->
        mul(num1, num2)
    }
    var value = mulFunction(4, 5) { num1: Int, num2: Int ->
        num1 * num2
    }
    println(value)

    val f = { x: Int -> x * x }
    println(f.javaClass)
}