import Vehicle.Vehicle

open class FlyingVehicle : Vehicle(){
    fun takeOff(){
        println("비행기가 이륙합니다.")
    }
    fun land(){
        println("비행기가 착륙합니다.")
    }

}