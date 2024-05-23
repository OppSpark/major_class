class Rectangle(
    override val width:Double,
    override val height:Double
):Shape() {
    override fun area() = width*height
}