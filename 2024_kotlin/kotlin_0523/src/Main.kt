fun Shape.print(){
    println("bounds: $width * $height, area : ${area()}")
}

fun main() {
    Circle(10.0).print()
}

