fun main() {
    val balls = readln().toInt()
    val share = readln().toInt()
    result(balls, share)
}

fun result(n:Int, m:Int) {
    println(factorial(n) / (factorial(n-m ) * factorial(m)))
}

fun factorial(n: Int): Long {
    var acc : Long = 1
    for (number in 1..n) {
        acc *= number
    }
    return acc
}