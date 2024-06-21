// Contoh 1

// Interface sebagai kontrak
interface Shape {
    fun draw()
}

// Implementasi interface pada kelas pertama
class Circle : Shape {
    override fun draw() {
        println("Drawing Circle")
    }
}

// Implementasi interface pada kelas kedua
class Square : Shape {
    override fun draw() {
        println("Drawing Square")
    }
}

fun main() {
    // Objek dari kelas Circle
    val circle: Shape = Circle()
    circle.draw()  // Output: Drawing Circle

    // Objek dari kelas Square
    val square: Shape = Square()
    square.draw()  // Output: Drawing Square
}

// Hasil Program 
Drawing Circle
Drawing Square


// Contoh 2

// Kelas dasar (superclass)
open class Animal {
    open fun makeSound() {
        println("Animal makes a sound")
    }
}

// Kelas turunan (subclass) pertama
class Dog : Animal() {
    override fun makeSound() {
        println("Dog barks")
    }

    fun fetch() {
        println("Dog is fetching")
    }
}

// Kelas turunan (subclass) kedua
class Cat : Animal() {
    override fun makeSound() {
        println("Cat meows")
    }

    fun scratch() {
        println("Cat is scratching")
    }
}

fun main() {
    // Objek dari kelas Animal
    val genericAnimal: Animal = Animal()
    genericAnimal.makeSound()  // Output: Animal makes a sound

    // Objek dari kelas Dog
    val myDog: Animal = Dog()
    myDog.makeSound()  // Output: Dog barks

    // Menggunakan metode yang khusus untuk kelas Dog
    if (myDog is Dog) {
        (myDog as Dog).fetch()  // Output: Dog is fetching
    }

    // Objek dari kelas Cat
    val myCat: Animal = Cat()
    myCat.makeSound()  // Output: Cat meows

    // Menggunakan metode yang khusus untuk kelas Cat
    if (myCat is Cat) {
        (myCat as Cat).scratch()  // Output: Cat is scratching
    }
}

// Hasil Program

Animal makes a sound
Dog barks
Dog is fetching
Cat meows
Cat is scratching

