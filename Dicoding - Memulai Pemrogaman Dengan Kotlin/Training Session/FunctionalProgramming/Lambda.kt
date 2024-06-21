//  Lambda Expression 

// Contoh 1

// Contoh lambda sebagai argumen fungsi
fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun main() {
    // Lambda sebagai ekspresi untuk penjumlahan
    val sum: (Int, Int) -> Int = { a, b -> a + b }
    println("Sum: ${operate(5, 3, sum)}")

    // Lambda sebagai ekspresi untuk pengurangan
    val subtract = { a: Int, b: Int -> a - b }
    println("Subtraction: ${operate(8, 4, subtract)}")

    // Lambda sebagai ekspresi untuk perkalian
    println("Multiplication: ${operate(6, 7) { a, b -> a * b }}")

    // Lambda tanpa parameter
    val greet: () -> Unit = { println("Hello, Kotlin Lambda!") }
    greet()
}

// Hasil Program 
Sum: 8
Subtraction: 4
Multiplication: 42
Hello, Kotlin Lambda!

// Contoh 2

// Lambda dengan satu parameter
val square: (Int) -> Int = { it * it }

// Lambda dengan dua parameter
val add: (Int, Int) -> Int = { a, b -> a + b }

// Lambda tanpa parameter
val greet: () -> Unit = { println("Hello, Kotlin Lambda!") }

// Lambda dengan tipe data yang berbeda
val concatenate: (String, Int) -> String = { str, num -> "$str $num" }

val mixedResult: (Int) -> Any = { num ->
    if (num % 2 == 0) {
        "Even"
    } else {
        3.14
    }
}

fun main() {
    println("Square of 5: ${square(5)}")
    println("Sum of 3 and 7: ${add(3, 7)}")
    greet()
    println("Concatenation: ${concatenate("Result:", 42)}")
    println(mixedResult(4)) 
}

// Hasil Program 

Square of 5: 25
Sum of 3 and 7: 10
Hello, Kotlin Lambda!
Concatenation: Result: 42


// Contoh 3

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // Menggunakan lambda expression untuk mencetak setiap elemen dalam daftar
    numbers.forEach { element ->
        println(element)
    }
}


// Hasil Program 
1
2
3
4
5

// Contoh 4

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // Menggunakan lambda expression dengan parameter indeks dan elemen
    numbers.forEachIndexed { index, element ->
        println("Index: $index, Element: $element")
    }
}

// Hasil Program

Index: 0, Element: 1
Index: 1, Element: 2
Index: 2, Element: 3
Index: 3, Element: 4
Index: 4, Element: 5

// Contoh 4

val satu = { name: String -> "Ini adalah $name" }

val dua: (String) -> String = {
    "Kedua ini adalah $it"
}

fun main() {
    tiga("Test", satu, dua)
}

fun tiga(name: String, satu: (String) -> String, dua: (String) -> String) {
    println(satu(name))
    print(dua(name))
}


// Hasil Program 
Ini adalah Test
Kedua ini adalah Test

