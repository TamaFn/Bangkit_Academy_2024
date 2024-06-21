
// 1. Extension 

// Extension function untuk String
fun String.addExclamation(): String {
    return "$this!"
}

// Extension function untuk MutableList<Int>
fun MutableList<Int>.customSort() {
    this.sortDescending()
}

fun main() {
    val greeting = "Hello"
    val modifiedGreeting = greeting.addExclamation()

    println("Original greeting: $greeting")
    println("Modified greeting: $modifiedGreeting")

    val numbers = mutableListOf(3, 1, 4, 1, 5, 9, 2, 6, 5)
    numbers.customSort()

    println("Sorted numbers in descending order: $numbers")
}

// Hasil Program
// Original greeting: Hello
// Modified greeting: Hello!
// Sorted numbers in descending order: [9, 6, 5, 5, 4, 3, 2, 1, 1]

// 2. Extension Properties

class Circle(var radius: Double)

// Extension property untuk Circle
val Circle.diameter: Double
    get() = radius * 2

fun main() {
    val circle = Circle(radius = 5.0)

    // Menggunakan extension property untuk mendapatkan diameter
    val diameter = circle.diameter

    println("Radius: ${circle.radius}")
    println("Diameter: $diameter")
}

// Hasil Program
// Radius: 5.0
// Diameter: 10.0

// Infix Function

class Calculator {
    infix fun add(b: Int): Int {
        return this.result + b
    }

    var result: Int = 0
}

fun main() {
    val calculator = Calculator()

    // Memanggil infix function untuk penjumlahan
    calculator.result = 5
    val newResult = calculator add 3 // Sama dengan calculator.add(3)

    println("Hasil penjumlahan: $newResult")
}

// Hasil Program 

Hasil penjumlahan: 8




