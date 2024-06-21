// Deklarasi data class
data class Person(val name: String, val age: Int)

fun main() {
    // Membuat objek data class
    val person1 = Person("John", 25)

    // Operasi salin (copy)
    val person2 = person1py(.co)

    println("Original Person: $person1")
    println("Copied Person: $person2")

    // Modifikasi objek data class
    val modifiedPerson = person1.copy(age = 26)

    println("Original Person: $person1")
    println("Modified Person: $modifiedPerson")

    // Destructuring declaration
    val (name, age) = person1
    println("Destructured: Name=$name, Age=$age")
}


// Hasil Program 
Original Person: Person(name=John, age=25)
Copied Person: Person(name=John, age=25)
Original Person: Person(name=John, age=25)
Modified Person: Person(name=John, age=26)
Destructured: Name=John, Age=25
