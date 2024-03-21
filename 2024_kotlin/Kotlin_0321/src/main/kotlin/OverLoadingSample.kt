fun restrictRange(
    from:Int = Int.MIN_VALUE,
    to:Int = Int.MAX_VALUE,
    what:Int
) :Int = Math.max(from, Math.min(to, what))

//vararg 를 사용하면 인자가 몇 개가 들어어돈 가변으로 처리한다.
fun printSorted(vararg item:Int) {
    item.sort()
    println(item.contentToString())
}

fun changeArray(vararg item: IntArray){
    item[0][0] = 100
}

fun mul(a:Int, b:Int=1) = a*b
fun mul(a:Int, b:Long=1L) = a*b
fun mul(a:Int, b:Int, c:Int=1) = a*b*c
fun mul(a:Int, b:Int, c:Boolean) {
    if (c == true) {
        a * b
    }
}