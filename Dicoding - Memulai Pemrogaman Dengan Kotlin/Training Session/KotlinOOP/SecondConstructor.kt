// Contoh 1

class Mahasiswa {
    var nama: String = ""
    var nim: String = ""

    // Primary constructor
    constructor(nama: String, nim: String) {
        this.nama = nama
        this.nim = nim
    }

    // Secondary constructor
    constructor(nama: String) : this(nama, "N/A") {
        // Anda dapat menambahkan inisialisasi tambahan jika diperlukan
    }
}

fun main() {
    // Menggunakan primary constructor
    val mahasiswa1 = Mahasiswa("John Doe", "12345")
    println("Nama: ${mahasiswa1.nama}, NIM: ${mahasiswa1.nim}")

    // Menggunakan secondary constructor
    val mahasiswa2 = Mahasiswa("Jane Doe")
    println("Nama: ${mahasiswa2.nama}, NIM: ${mahasiswa2.nim}")
}

// Hasil Program 
Nama: John Doe, NIM: 12345
Nama: Jane Doe, NIM: N/A


//  Contoh 2

class Car {
    var brand: String = ""
    var model: String = ""
    var year: Int = 0

    // Primary constructor
    constructor(brand: String, model: String, year: Int) {
        this.brand = brand
        this.model = model
        this.year = year
    }

    // Secondary constructor
    constructor(brand: String, model: String) : this(brand, model, 0) {
        // Secondary constructor dapat melakukan inisialisasi tambahan atau logika
        println("Secondary constructor called for $brand $model")
    }

    fun displayInfo() {
        println("Car: $brand $model, Year: $year")
    }
}

fun main() {
    // Menggunakan primary constructor
    val car1 = Car("Toyota", "Camry", 2022)
    car1.displayInfo()

    // Menggunakan secondary constructor
    val car2 = Car("Honda", "Civic")
    car2.displayInfo()
}


// Hasil Program 
Car: Toyota Camry, Year: 2022
Secondary constructor called for Honda Civic
Car: Honda Civic, Year: 0


