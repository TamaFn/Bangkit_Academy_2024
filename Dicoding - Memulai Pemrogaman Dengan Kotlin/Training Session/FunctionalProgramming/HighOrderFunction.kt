//  Contoh 1

// Contoh High Order Function yang menerima fungsi sebagai parameter
fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

// Contoh fungsi yang akan digunakan sebagai argumen untuk High Order Function
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun main() {
    // Menggunakan High Order Function dengan fungsi sum
    val resultSum = operate(5, 3, ::sum)
    println("Sum: $resultSum")

    // Menggunakan High Order Function dengan fungsi multiply
    val resultMultiply = operate(4, 6, ::multiply)
    println("Multiply: $resultMultiply")

    // Menggunakan High Order Function dengan lambda
    val resultLambda = operate(8, 2) { a, b -> a / b }
    println("Division: $resultLambda")
}


// Hasil Program
Sum: 8
Multiply: 24
Division: 4

// Contoh 2

// Contoh High Order Function dengan menggunakan lambda
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun main() {
    // Menggunakan lambda untuk penjumlahan
    val sumResult = calculate(5, 3) { a, b -> a + b }
    println("Sum: $sumResult")

    // Menggunakan lambda untuk perkalian
    val multiplyResult = calculate(4, 6) { a, b -> a * b }
    println("Multiply: $multiplyResult")

    // Menggunakan lambda untuk pengurangan
    val subtractResult = calculate(8, 2) { a, b -> a - b }
    println("Subtract: $subtractResult")

    // Menggunakan lambda dengan operasi kustom
    val customOperationResult = calculate(10, 3) { a, b ->
        val squared = a * a
        squared + b
    }
    println("Custom Operation: $customOperationResult")
}


// Hasil Program 
Sum: 8
Multiply: 24
Subtract: 6
Custom Operation: 103

