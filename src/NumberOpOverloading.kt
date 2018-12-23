
class NumberOpOverloading(var value: Int) {

    operator fun plus(r: NumberOpOverloading): Int  {
        return this.value + r.value
    }
    operator fun plus(num: Int): Int  {
        return this.value + num
    }

    operator fun minus(r: NumberOpOverloading): Int  {
        return this.value - r.value
    }

    operator fun minus(num: Int): Int  {
        return this.value - num
    }
    operator fun times(r: NumberOpOverloading): Int  {
        return this.value * r.value
    }

    operator fun times(num: Int): Int  {
        return this.value * num
    }

    operator fun div(r: NumberOpOverloading): Int  {
        return this.value / r.value
    }

    operator fun div(num: Int): Int  {
        return this.value / num
    }

    override fun equals(r: Any?): Boolean {
       return (r is NumberOpOverloading && (r as NumberOpOverloading).value == this.value)
    }

    override fun toString():String{
       return " the number is ${value}"
    }
}


fun main(args: Array<String>) {
    var one= NumberOpOverloading(1)
    var two= NumberOpOverloading(2)
    println(one + two)
    println(two + 2)
}