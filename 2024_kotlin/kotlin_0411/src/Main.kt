import java.lang.Character.isLowerCase
import java.util.concurrent.locks.Condition

fun main() {
    /*println(check("Hello"){_, c -> c.isLowerCase()})

    var sum = 0
    print(forEach(intArrayOf(1,2,3,4,5),
        fun (i):Unit { sum += i }
        )
    )
    println(sum)

    println(check2("hello", ::isLowerCase))

     */

    val createPerson = ::Person
    val p = createPerson("Alice", "Smith")

    val isJohn = Person("John", "Doe")::hasNameOf

    println(isJohn("john"))
    println(isJohn("alice"))

}












fun check2(s:String, condition:(Char) -> Boolean):Boolean {
    for (c in s) {
        if (!condition(c)) {
            return false
        }
    }
    return true
}
fun isCapitalLetter(c:Char) =  c.isUpperCase() && c.isLetter()


fun check(s:String, condition:(Int, Char) -> Boolean):Boolean {
    for (i in s.indices) {
        if (!condition(i, s[i])) {
            return false
        }
    }
    return true
}

fun forEach(a:IntArray, action:(Int)-> Unit ){
    for(n in a){
        action(n)
    }
}
