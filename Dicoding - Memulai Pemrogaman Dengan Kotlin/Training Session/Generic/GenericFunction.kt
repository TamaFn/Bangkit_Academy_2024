// Contoh 1

class GenericClass<T>(private val genericField: T) {
    fun <U> genericFunction(parameter: U) {
        println("GenericField: $genericField, GenericParameter: $parameter")
    }

    fun <U, V> multipleGenericFunction(parameter1: U, parameter2: V) {
        println("GenericField: $genericField, GenericParameter1: $parameter1, GenericParameter2: $parameter2")
    }
}

fun main() {
    // Contoh penggunaan generic class dengan satu generic function
    val intGenericClass = GenericClass(10)
    intGenericClass.genericFunction("Hello")

    // Contoh penggunaan generic class dengan dua generic function
    val stringGenericClass = GenericClass("World")
    stringGenericClass.multipleGenericFunction(3.14, true)
}

// Hasil Program 

GenericField: 10, GenericParameter: Hello
GenericField: World, GenericParameter1: 3.14, GenericParameter2: true

// Contoh 2

// Generic function dengan satu parameter
fun <T> printSingleParameter(value: T) {
    println("Single Parameter: $value")
}

// Generic function dengan dua parameter
fun <T, U> printTwoParameters(param1: T, param2: U) {
    println("Parameter 1: $param1, Parameter 2: $param2")
}

fun main() {
    // Contoh pemanggilan generic function dengan satu parameter
    printSingleParameter("Hello, World!")

    // Contoh pemanggilan generic function dengan dua parameter
    printTwoParameters(42, "Kotlin")
}

// Hasil Program 
Single Parameter: Hello, World!
Parameter 1: 42, Parameter 2: Kotlin
