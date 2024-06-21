class Car(var brand: String, var model: String, var year: Int)

fun main() {
    // apply: Menginisialisasi objek dan mengatur propertinya, kemudian mengembalikan objek tersebut
    val carApply = Car("Toyota", "Camry", 2022).apply {
        println("apply: Initializing $brand $model, year $year")
    }

    // also: Melakukan tindakan tambahan pada objek dan mengembalikan objek tersebut
    val carAlso = Car("Honda", "Civic", 2020).also {
        println("also: Initializing ${it.brand} ${it.model}, year ${it.year}")
    }

    // let: Melakukan operasi pada objek dan mengembalikan hasil operasi tersebut
    val carLet = Car("Ford", "Mustang", 2019).let {
        println("let: Initializing ${it.brand} ${it.model}, year ${it.year}")
        "Result: ${it.brand} ${it.model} is from ${it.year}" // return value
    }
    println("let result: $carLet")

    // run: Menjalankan blok kode pada objek dan mengembalikan hasil blok kode tersebut
    val carRun = Car("Chevrolet", "Malibu", 2021).run {
        println("run: Initializing $brand $model, year $year")
        "Result: $brand $model is a $year model" // return value
    }
    println("run result: $carRun")

    // with: Menggunakan objek sebagai receiver untuk blok kode dan mengembalikan hasil blok kode tersebut
    val carWithResult = with(Car("Nissan", "Altima", 2018)) {
        println("with: Initializing $brand $model, year $year")
        "Result: $brand $model is a $year model" // return value
    }
    println("with result: $carWithResult")
}


// Hasil Program 

apply: Initializing Toyota Camry, year 2022
also: Initializing Honda Civic, year 2020
let: Initializing Ford Mustang, year 2019
let result: Result: Ford Mustang is from 2019
run: Initializing Chevrolet Malibu, year 2021
run result: Result: Chevrolet Malibu is a 2021 model
with: Initializing Nissan Altima, year 2018
with result: Result: Nissan Altima is a 2018 model


