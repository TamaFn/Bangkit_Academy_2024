import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

// Contoh 1
// Interface untuk tugas tertentu
interface Worker {
    fun doWork()
}

// Implementasi dari interface Worker
class Employee : Worker {
    override fun doWork() {
        println("Employee is working.")
    }
}

// Kelas yang menggunakan delegation untuk menangani pekerjaan
class TeamLead(worker: Worker) : Worker by worker

fun main() {
    // Membuat instance dari Employee
    val employee = Employee()

    // Membuat instance dari TeamLead dengan menggunakan delegation ke employee
    val teamLead = TeamLead(employee)

    // Memanggil metode doWork melalui delegation
    teamLead.doWork()
}

// Hasil Program
// Employee is working.


// Contoh 2
interface FruitBasket {
    fun getFruitsCount(): Int
}

class AppleBasket : FruitBasket {
    override fun getFruitsCount(): Int {
        return 10
    }
}

class OrangeBasket : FruitBasket {
    override fun getFruitsCount(): Int {
        return 15
    }
}

class FruitCountDelegate(private val basket: FruitBasket) : ReadOnlyProperty<Any?, Int> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return basket.getFruitsCount()
    }
}

class CombinedBasket(appleBasket: FruitBasket, orangeBasket: FruitBasket) : FruitBasket by appleBasket {
    val oranges: Int by FruitCountDelegate(orangeBasket)

    fun getTotalFruitsCount(): Int {
        return getFruitsCount() + oranges
    }
}

fun main() {
    val appleBasket = AppleBasket()
    val orangeBasket = OrangeBasket()

    val combinedBasket = CombinedBasket(appleBasket, orangeBasket)

    println("Total fruits in combined basket: ${combinedBasket.getTotalFruitsCount()}")
}

// Hasil Program
// Total fruits in combined basket: 25

// Contoh 3

interface TextPrinter {
    fun printText(text: String)
}

class Printer : TextPrinter {
    override fun printText(text: String) {
        println("Printing: $text")
    }
}

class UpperCasePrinter(private val printer: TextPrinter) : TextPrinter by printer {
    override fun printText(text: String) {
        val upperCaseText = text.toUpperCase()
        printer.printText(upperCaseText)
    }
}

fun main() {
    val printer = Printer()
    
    val upperCasePrinter = UpperCasePrinter(printer)

    // Mencetak teks dengan Printer biasa
    printer.printText("Hello, World!")

    // Mencetak teks dengan UpperCasePrinter
    upperCasePrinter.printText("Hello, World!")
}

// Hasil Program
// Printing: Hello, World!
// Printing: HELLO, WORLD!

