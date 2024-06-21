// Implementation Getter dan Setter

class Person {
    // Properties
    var name: String = ""
        // Getter
        get() {
            println("Getting name value")
            return field
        }
        // Setter
        set(value) {
            println("Setting name value to $value")
            field = value
        }

    var age: Int = 0
        // Getter
        get() {
            println("Getting age value")
            return field
        }
        // Setter
        set(value) {
            println("Setting age value to $value")
            field = value
        }
}

fun main() {
    val person = Person()

    // Menggunakan setter
    person.name = "John"
    person.age = 25

    // Menggunakan getter
    val retrievedName = person.name
    val retrievedAge = person.age

    // Menampilkan nilai yang telah diambil
    println("Name: $retrievedName")
    println("Age: $retrievedAge")
}

// Hasil Program
// Setting name value to John
// Setting age value to 25
// Getting name value
// Getting age value
// Name: John
// Age: 25
