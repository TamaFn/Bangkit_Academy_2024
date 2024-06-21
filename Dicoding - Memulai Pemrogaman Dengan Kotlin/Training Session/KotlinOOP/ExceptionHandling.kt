fun divide(a: Int, b: Int): Int {
    if (b == 0) {
        throw IllegalArgumentException("Pembagian oleh nol tidak diperbolehkan.")
    }
    return a / b
}

fun main() {
    try {
        val result = divide(10, 2)
        println("Hasil pembagian: $result")

        // Mencoba pembagian oleh nol
        val resultWithException = divide(8, 0)
        println("Hasil pembagian: $resultWithException")
    } catch (e: IllegalArgumentException) {
        println("Exception: ${e.message}")
    } catch (e: ArithmeticException) {
        println("Terjadi kesalahan aritmatika: ${e.message}")
    } finally {
        println("Ini akan selalu dieksekusi, baik terjadi exception atau tidak.")
    }
}

// Hasil Program 
Hasil pembagian: 5
Exception: Pembagian oleh nol tidak diperbolehkan.
Ini akan selalu dieksekusi, baik terjadi exception atau tidak.
