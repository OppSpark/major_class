import java.util.Date
import kotlin.io.readLine
import kotlin.io.readLine as readLine1


fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages < 100)
        return println("You have $numberOfMessages notifications.")
    else
        return println("Your phone is blowing up! You have 99+ notifications.")
}
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

}


    /*
    //val b = readLine()!!.toInt()
    //val a = readLine()!!.toInt()

    val c : Int  //초기값을 입력 안할 수 있다. 그러나 타입은 정해줘여함

    val d = "Str"  // 타입 추론으로 String 으로 인식함함

    val bin = 0b1001011101010 //0b 를 붙이면 2진수
    val hex = 0xF9  // 0f 를 붙이면 16진수

    // 앞에 - 를 붙이면 음수도 가능하다.
    val min_bin = -0b100101110101


    val char1 = 'a'  //Char 타입 'a' 쌍따움표가아닌 일반 따움표를 사용한다.
    val char2 = 'h'



    val n = 100


    println(char1 - char2)
    println(char2 + 3)


    println(bin)
    println(hex)

    println(min_bin)

    println(hex + min_bin)
*/
