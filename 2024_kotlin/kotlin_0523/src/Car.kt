class Car : Vehicle {
    override var currentSpeed = 0
        private set

    override fun move() {
        println("Riding . . .")
        currentSpeed = 50
    }

    override fun stop() {
        println("Stoppring . . .")
        currentSpeed = 0
    }
}