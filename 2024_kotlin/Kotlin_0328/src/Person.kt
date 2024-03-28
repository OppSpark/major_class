class Person(val firstName: String, val familyName: String){
    class Id(val firstName:String, val familyName : String)
    inner class Possession(val description : String){
        fun shoOwner() = println(fullName())
        fun getOwner() = this@Person
        fun fullName() = "$firstName $familyName"
    }
}








/*
class Person (firstName: String, familyName: String) {
    val fullName = "$firstName $familyName"

    var firstName: String = firstName
    var familyName: String =familyName
    var age: Int = 0

    init {  //초기화 블럭
        println("주 생성자가 실행됨 : $fullName")
    }

    fun showMe() {
        println("$fullName : $age");
    }
}

class PersonFullName(fullName: String) {
    val firstName: String
    val familyName: String
    var age: Int = 0

    init{
        val names = fullName.split(" ")
        if(names.size != 2){
            throw IllegalArgumentException("Invalid Name : ${fullName}")
        }
        firstName = names[0]
        familyName = names[1]
    }

    init {  //초기화 블럭
        println("주 생성자가 실행됨 : $fullName")
    }

    fun showMe() {
        println("${firstName} ${familyName} : $age");
    }
}

class Person1(val firstName: String, val familyName: String){
    fun fullname() ="$ firstName $familyName"


}


class Room(vararg  val personFullName: PersonFullName){
    fun showNames(){
        for(personFullName : p)
    }
}

 */