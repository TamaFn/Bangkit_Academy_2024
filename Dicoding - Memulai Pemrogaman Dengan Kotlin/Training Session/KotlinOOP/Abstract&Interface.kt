// Contoh 1

// Contoh 2

// Abstract class sebagai kelas dasar
abstract class Animal(val name: String) {
    abstract fun makeSound()
    open fun sleep() {
        println("$name is sleeping")
    }
}

// Interface sebagai kontrak tambahan
interface CanSwim {
    fun swim()
}

// Kelas yang menggabungkan abstract class dan interface
class Dolphin(name: String) : Animal(name), CanSwim {
    override fun makeSound() {
        println("$name squeaks")
    }

    override fun swim() {
        println("$name is swimming")
    }
}

fun main() {
    val dolphin = Dolphin("Dolly")
    dolphin.makeSound() // Output: Dolly squeaks
    dolphin.swim()      // Output: Dolly is swimming
    dolphin.sleep()     // Output: Dolly is sleeping
}

// Hasil Program 

Dolly squeaks
Dolly is swimming
Dolly is sleeping
