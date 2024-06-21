// Contoh 1

class Box<T>(val content: T)

fun main() {
    val intBox = Box(42)
    val stringBox = Box("Kotlin")
    val doubleBox = Box(3.14)

    println("Int Box Content: ${intBox.content}")
    println("String Box Content: ${stringBox.content}")
    println("Double Box Content: ${doubleBox.content}")
}

// Hasil Program 

Int Box Content: 42
String Box Content: Kotlin
Double Box Content: 3.14


// Contoh 2

class PairContainer<A, B>(val first: A, val second: B) {
    fun displayPairInfo() {
        println("Pair Info: First=$first, Second=$second")
    }
}

fun main() {
    val intStringPair = PairContainer(42, "Kotlin")
    val doubleBooleanPair = PairContainer(3.14, true)

    intStringPair.displayPairInfo()
    doubleBooleanPair.displayPairInfo()
}

// Hasil Program
Pair Info: First=42, Second=Kotlin
Pair Info: First=3.14, Second=true

// Contoh 3

class PairContainer<A, B>(val first: A, val second: B) {
    fun displayPairInfo() {
        println("Pair Info: First=$first, Second=$second")
    }

    fun swapElements(): PairContainer<B, A> {
        return PairContainer(second, first)
    }

    fun combineToString(): String {
        return "$first$second"
    }
}

fun main() {
    val intStringPair = PairContainer(42, "Kotlin")
    val doubleBooleanPair = PairContainer(3.14, true)

    intStringPair.displayPairInfo()
    println("Combined String: ${intStringPair.combineToString()}")

    val swappedPair = intStringPair.swapElements()
    println("Swapped Pair Info: First=${swappedPair.first}, Second=${swappedPair.second}")
}

// Hasil Program 
Pair Info: First=42, Second=Kotlin
Combined String: 42Kotlin
Swapped Pair Info: First=Kotlin, Second=42




