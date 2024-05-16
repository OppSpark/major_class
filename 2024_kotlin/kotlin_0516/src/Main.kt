import Vehicle.Vehicle
import java.io.FileReader
import java.io.FileWriter

fun main(){
    /*
    val int_arr = intArrayOf(26,15,4,74,21,86,75,32,2)
    //장렬됨
    print(int_arr.sorted())
    println(int_arr.contentToString())
    //역순으러 정렬
    println(int_arr.sortDescending())
    //출력
    println(int_arr.contentToString())


    // 파일 읽고 쓰기 연습
    FileWriter("data.txt").use { it.write("One\nTwo\nThree") }
    FileReader("data.txt").buffered().use { println(it.readLine()) }
    FileReader("data.txt").use {
        println(it.readText().replace('\n', ' '))
    }
    println(FileReader("data.txt").readLines())
     */

    val aircraft = Aircraft(100)
    aircraft.start()
    aircraft.takeOff()
    aircraft.land()
    aircraft.stop()

    val Vehicle = Vehicle()
    Vehicle.start()
    Vehicle.stop()

}