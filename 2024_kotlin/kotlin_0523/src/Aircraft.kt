class Aircraft:FlyingVehicle {
    override var currentHeight = 0
        private set
    override var currentSpeed = 0
        private set

    override fun takeOfff() {
        println("Tacking Off ..")
        currentHeight = 5000
    }

    override fun land() {
        println("Landed")
        currentSpeed = 0
    }

    override fun move() {
        println("Moving")
        currentSpeed = 50
    }

    override fun stop() {
        println("Stoppring")
        currentSpeed = 0
    }
}