// Penggunaan open dalam class dan properties

// Open Class
open class Kendaraan {
    open fun info() {
        println("Ini adalah kendaraan.")
    }
}

class Mobil : Kendaraan() {
    override fun info() {
        println("Ini adalah mobil.")
    }
}

Pada contoh di atas, Kendaraan dideklarasikan dengan kata kunci open, 
sehingga Mobil dapat meng-override metode info() dari kelas Kendaraan.

// Open Properties

open class Manusia {
    open var nama: String = "John Doe"
}

class Mahasiswa : Manusia() {
    override var nama: String = "Jane Doe"
}

Pada contoh ini, properti nama pada kelas Manusia di-deklarasikan dengan kata kunci open, 
sehingga properti tersebut dapat di-override oleh kelas turunannya, seperti Mahasiswa pada contoh di atas.

// Contoh 1

open class Animal(val name: String) {
    open fun makeSound() {
        println("Animal makes a sound")
    }
}

class Cat(pName: String) : Animal(pName) {
    override fun makeSound() {
        println("$name meows")
    }
}

class Dog(pName: String) : Animal(pName) {
    override fun makeSound() {
        println("$name is barking")
    }
}

fun main() {
    val animal: Animal = Dog("Fluffy")
    animal.makeSound() // Output: Fluffy is barking
}

// Hasil Program 
Fluffy is barking



