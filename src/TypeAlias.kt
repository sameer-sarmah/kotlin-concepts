typealias Row = List<Int>
typealias Matrix = List<Row>

fun convertIntArrayToRow(vararg xs: Int): Row {
    return xs.asList()
}

fun convertRowToMatrix(vararg xs: Row): Matrix {
    return xs.asList()
}

fun main(args: Array<String>): Unit {

    val row1 = convertIntArrayToRow(1, 2, 3)
    val row2 = convertIntArrayToRow(4, 5, 6)
    val row3 = convertIntArrayToRow(7, 8, 9)
    val matrix = convertRowToMatrix(row1, row2, row3)


    println(matrix)
    println(matrix.javaClass)
}