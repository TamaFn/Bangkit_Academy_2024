// Contoh 1

// Contoh kelas generik dengan constraint type parameter
class Box<T : Number>(private val value: T) {
    fun getValue(): T {
        return value
    }
}

fun main() {
    // Membuat objek Box dengan Integer sebagai tipe parameter
    val intBox = Box(10)
    println("Integer Box Value: ${intBox.getValue()}")

    // Membuat objek Box dengan Double sebagai tipe parameter
    val doubleBox = Box(3.14)
    println("Double Box Value: ${doubleBox.getValue()}")

    // Mencoba membuat objek Box dengan String sebagai tipe parameter (akan menyebabkan kesalahan kompilasi)
    // val stringBox = Box("Hello") // Error: Type parameter bound for T in Box is not satisfied: inferred type is String but Number was expected
}


// Hasil Program 

Integer Box Value: 10
Double Box Value: 3.14

// Contoh 2

// Contoh fungsi generik dengan satu parameter dan constraint
fun <T : Comparable<T>> findMax(value1: T, value2: T): T {
    return if (value1 > value2) value1 else value2
}

// Contoh fungsi generik dengan multiple parameter dan multiple constraint menggunakan where clause
fun <T, U> combineAndPrint(first: T, second: U)
        where T : CharSequence, U : Number {
    println("Combined Value: ${first.length * second.toInt()}")
}

fun main() {
    // Contoh pemanggilan fungsi findMax dengan tipe data yang memenuhi constraint Comparable
    val maxInt = findMax(5, 10)
    println("Maximum Integer: $maxInt")

    // Contoh pemanggilan fungsi findMax dengan tipe data String yang memenuhi constraint Comparable
    val maxString = findMax("abc", "xyz")
    println("Maximum String: $maxString")

    // Contoh pemanggilan fungsi combineAndPrint dengan tipe data yang memenuhi constraint CharSequence dan Number
    combineAndPrint("Hello", 5)
}

// Hasil Program

