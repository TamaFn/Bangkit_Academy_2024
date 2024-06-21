Perbedaan enum dan sealed class

- Enum Class

1. enum class digunakan untuk mewakili kumpulan nilai yang terbatas.
2. Setiap elemen dalam enum class adalah objek konstan
3. Dapat Menggunakan Properti dan Metode

Contoh 

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

- Sealed Class

1. sealed class juga digunakan untuk mewakili kumpulan nilai yang terbatas, 
tetapi dengan lebih fleksibilitas
2. sealed class dapat membentuk hirarki 
nilai di mana setiap nilai adalah subtype dari sealed class
3. Instansiasi nilai-nilai dari sealed class hanya dapat dilakukan 
di dalam deklarasi kelas itu sendiri atau di dalam file yang sama.

enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Square(val side: Double) : Shape()
}

fun main() {
    // Penggunaan enum class Direction
    val currentDirection = Direction.NORTH

    when (currentDirection) {
        Direction.NORTH -> println("Heading North")
        Direction.SOUTH -> println("Heading South")
        Direction.EAST -> println("Heading East")
        Direction.WEST -> println("Heading West")
    }

    // Penggunaan sealed class Shape
    val circle: Shape = Shape.Circle(radius = 5.0)
    val square: Shape = Shape.Square(side = 4.0)

    displayShapeInfo(circle)
    displayShapeInfo(square)
}

fun displayShapeInfo(shape: Shape) {
    when (shape) {
        is Shape.Circle -> {
            println("Circle with radius ${shape.radius}")
        }
        is Shape.Square -> {
            println("Square with side ${shape.side}")
        }
    }
}

// Hasil Program 

Heading North
Circle with radius 5.0
Square with side 4.0

//  Contoh Sealed Class 

sealed class DeliveryStatus {
    data class InTransit(val location: String) : DeliveryStatus()
    object Delivered : DeliveryStatus()
    object FailedDelivery : DeliveryStatus()
    object Pending : DeliveryStatus()
}

fun trackDeliveryStatus(status: DeliveryStatus): String {
    return when (status) {
        is DeliveryStatus.InTransit -> "Package is in transit at ${status.location}"
        is DeliveryStatus.Delivered -> "Package has been delivered"
        is DeliveryStatus.FailedDelivery -> "Delivery attempt failed"
        is DeliveryStatus.Pending -> "Delivery is pending"
    }
}

fun main() {
    val inTransitStatus = DeliveryStatus.InTransit(location = "Distribution Center")
    val deliveredStatus = DeliveryStatus.Delivered
    val failedStatus = DeliveryStatus.FailedDelivery
    val pendingStatus = DeliveryStatus.Pending

    println(trackDeliveryStatus(inTransitStatus))
    println(trackDeliveryStatus(deliveredStatus))
    println(trackDeliveryStatus(failedStatus))
    println(trackDeliveryStatus(pendingStatus))
}

//  Hasil Program 

Package is in transit at Distribution Center
Package has been delivered
Delivery attempt failed
Delivery is pending





