//  Contoh 1

class Person(val name: String, var age: Int) {
    // Metode untuk memberikan sapaan
    fun greet() {
        println("Hello, my name is $name and I'm $age years old.")
    }

    // Metode untuk ulang tahun
    fun celebrateBirthday() {
        age++
        println("Happy Birthday! Now I'm $age years old.")
    }
}

fun main() {
    // Membuat objek Person
    val person = Person("John", 25)

    // Memanggil metode greet
    person.greet()

    // Memanggil metode celebrateBirthday
    person.celebrateBirthday()
}

// Hasil Program 
Hello, my name is John and I'm 25 years old.
Happy Birthday! Now I'm 26 years old.

// Contoh 2 (Menggunakan Init Block)

class Car(make: String, model: String, year: Int) {
    // Properties
    var make: String
    var model: String
    var year: Int
    var isEngineRunning: Boolean = false

    // Init block untuk inisialisasi
    init {
        this.make = make.capitalize()
        this.model = model.capitalize()
        this.year = if (year > 0) year else 2022 // Year tidak boleh negatif, default ke 2022 jika tidak valid
    }

    // Method untuk menampilkan informasi mobil
    fun displayInfo() {
        println("Make: $make")
        println("Model: $model")
        println("Year: $year")
        println("Engine Status: ${if (isEngineRunning) "Running" else "Not Running"}")
    }

    // Method untuk menghidupkan mesin
    fun startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true
            println("Engine is now running.")
        } else {
            println("Engine is already running.")
        }
    }

    // Method untuk mematikan mesin
    fun stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false
            println("Engine is now stopped.")
        } else {
            println("Engine is already stopped.")
        }
    }
}

fun main() {
    // Membuat objek Car
    val car1 = Car("Toyota", "Camry", 2020)
    
    // Menampilkan informasi awal mobil
    println("Initial Car Info:")
    car1.displayInfo()

    // Menghidupkan mesin
    car1.startEngine()

    // Menampilkan informasi setelah menghidupkan mesin
    println("\nCar Info After Starting Engine:")
    car1.displayInfo()

    // Mematikan mesin
    car1.stopEngine()

    // Menampilkan informasi setelah mematikan mesin
    println("\nCar Info After Stopping Engine:")
    car1.displayInfo()
}

// Hasil Program

Initial Car Info:
Make: Toyota
Model: Camry
Year: 2020
Engine Status: Not Running
Engine is now running.

Car Info After Starting Engine:
Make: Toyota
Model: Camry
Year: 2020
Engine Status: Running
Engine is now stopped.

Car Info After Stopping Engine:
Make: Toyota
Model: Camry
Year: 2020
Engine Status: Not Running


// Contoh 2

fun main() {
    val dicodingCat = Animal("Dicoding Miaw", 4.2, 2, true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}")
}
 
/*
output:
    Nama: Dicoding Miaw, Berat: 4.2, Umur: 2, mamalia: true
*/

class Animal(pName: String, pWeight: Double, pAge: Int, pIsMammal: Boolean){
    val name: String
    val weight: Double
    val age: Int
    val isMammal: Boolean
 
    init {
        weight = if(pWeight < 0) 0.1 else pWeight
        age = if(pAge < 0) 0 else pAge
        name = pName
        isMammal = pIsMammal
    }
}

// Hasil Program 
Nama: Dicoding Miaw, Berat: 4.2, Umur: 2, mamalia: true


