fun aggregate(numbers: IntArray, op:(Int, Int) -> Int): Int {
    var result = numbers.firstOrNull()?:
    throw IllegalArgumentException("No numbers")
    for (i in 1 until numbers.lastIndex)
        result += op(result, numbers[i])

    return result
}

fun sum(numbers: IntArray): Int {
    var result = numbers.firstOrNull()?:
        throw IllegalArgumentException("No numbers")
    for (i in 1 until numbers.lastIndex)
        result += numbers[i]

    return result
}
fun max(numbers: IntArray) = aggregate(numbers, {result, op -> if(result>op) op else result})

fun main(){
    println(sum(intArrayOf(1,2,3,4,5)))
    println(aggregate(intArrayOf(1,2,3,4,5), Int::plus))
    println(max(intArrayOf(1,2,3,4,5)))
}

/*
/*

object Application{
    val name = "My Application"
    override  fun toString() = name
    fun exit(){}
}
 */

class Application private constructor(val name:String){
    object  Factory{
        fun create(args: Array<String>): Application?{
            val name:String = args.firstOrNull()?: return null
            return Application(name)
        }
    }
}

fun main(args: Array<String>){
    val app = Application.Factory.create(args)?:return
    println(app.name)

    /*
    println(Application)
    println("${Application}")
    // 같은 의미를 가진다.

     */


/*
    while(true){
        when(val comment:String = readln()?: return) {
            "print data" -> println(text)
            "exit" -> return
        }
    }

    val person = Person("JKP")
    println(person.name)  // 초기값의 이름
    person.name = " Pororo"  // 변경한 이름
    println(person.lastChanged) //변경한 시간에 출력됨

    val Person = Person("JK","P")
    Person.age = 20  //Setter를 이용해 age값을 설절

    println(Person.fullName)
    println(Person.age)
    */
}

class Person(name: String
/*val firstName:String, val familyName:String, name */
) {
    var lastChanged: Date? = null
        private set

    var name:String = name
        set(value){
            lastChanged = Date()
            field =value
        }

    /*

    val fullName: String
        get():String {
            return "$firstName $familyName"
        }

    var age:Int? = null   //Setter를 이용해서 age값을 받는 예시
        set(value){
            if(value != null && value<=0)
                throw IllegalArgumentException("Invalid age $value")

            field = value
        }
        get(){
            println("Accessing age")
            return field
        }
    */
}

val text by lazy{   //lazy 객체를 사용하면 지연 계산이 가능하다.
    File("testfile.txt").readText()
}

 */
