interface Vehicle {
    val currentSpeed:Int
    val isMoving get() = currentSpeed != 0
    fun move()
    fun stop()
    fun report(){
        println(if (isMoving) "Moving at $currentSpeed" else "Still")
    }
}