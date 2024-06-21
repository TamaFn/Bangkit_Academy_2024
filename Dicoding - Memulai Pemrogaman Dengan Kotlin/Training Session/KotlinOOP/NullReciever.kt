class Calculator {
    var result: Int? = null

    infix fun add(b: Int): Int {
        if (result != null) {
            return result!! + b
        } else {
            return b
        }
    }
}

fun main() {
    val calculator = Calculator()

    // Memanggil infix function untuk penjumlahan pada nullable receiver
    val newResult = calculator add 3 // Sama dengan calculator?.add(3)

    println("Hasil penjumlahan: $newResult")
}

// Hasil Program

Hasil penjumlahan: 3