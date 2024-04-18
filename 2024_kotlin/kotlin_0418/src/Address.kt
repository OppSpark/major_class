/*
class Address {
    var zipCode:Int=0
    var city:String=""
    var street:String=""
    var house:String=""

    fun post(message:String):Boolean{

        println("Message for {$city} {$street} {$house} {$zipCode}: $message")
 8       return readln()== "ok"
    }
}
*/


class Address(val city:String, val street:String, val house:String){
    fun asText() = "$city, $street, $house"
}