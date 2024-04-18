
class Person(val firstName:String, val familyName:String){
    fun Address.post(message:String){
        val city = city //암시적 this: 확장 수신 객체 (Address)
        val street = this.street //한정시키지 않은 this: 확장 수신 객체 (Address)
        val house = this@post.house //한정시킨 this: 확장 수신 객체 (Address)
        val firstName = firstName //암시적 this: 디스패치 수신 객체 (Person)
        val familyName = this@Person.familyName //한정시킨 this: 디스패치 수신 객체(Person)
        println("From $firstName, $familyName at $city, $street, $house")
        println(message)
    }
    fun test(address:Address){ //디스패치 수신객체 : 암시적
        address.post("Hello") //확장 수신객체 : 명시적
    }
}