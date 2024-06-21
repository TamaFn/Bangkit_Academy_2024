// SINGLETON OBJECT 

1. Singleton adalah sebuah pola desain yang memastikan bahwa 
sebuah kelas memiliki hanya satu instance dan menyediakan 
cara untuk mengakses instance tersebut dari titik akses global. 
2. Dengan kata lain, Singleton memastikan bahwa hanya ada satu objek 
dibuat untuk suatu kelas dan menyediakan cara untuk mendapatkan 
objek tersebut.
3. Dengan kata lain, singleton object adalah object yang dibuat satu kali 
4. Singleton tidak punya construtor

// Contoh 1
object AppConfig {
    var theme: String = "Light"
    var language: String = "English"

    fun displayConfig() {
        println("Theme: $theme, Language: $language")
    }
}

fun main() {
    AppConfig.displayConfig()  // Mengakses properti dan fungsi dari singleton object
    AppConfig.theme = "Dark"   // Mengubah nilai properti
    AppConfig.displayConfig()  // Menampilkan konfigurasi setelah perubahan
}

// Hasil Program 
Theme: Light, Language: English
Theme: Dark, Language: English

// INNER OBJECT

Singleton object bisa dibuat di dalam sebuah class
Singleton object tidak bisa mengakses properties atau funtion yang ada di outer class

class OuterClass {
    // Properti dari kelas luar
    private val outerProperty: String = "Outer Property"

    // Inner object di dalam kelas luar
    object InnerObject {
        fun innerFunction() {
            println("Inner Function")
        }
    }

    fun outerFunction() {
        println("Outer Function")
    }

    fun accessInnerObject() {
        // Mengakses properti dan fungsi inner object dari kelas luar
        println("Accessing Inner Object from Outer Class:")
        println("Outer Property: $outerProperty")
        InnerObject.innerFunction()
    }
}

fun main() {
    val outerInstance = OuterClass()

    // Mengakses fungsi dari kelas luar
    outerInstance.outerFunction()

    // Mengakses inner object dari kelas luar
    outerInstance.accessInnerObject()

    // Jika diperlukan, inner object dapat diakses langsung
    OuterClass.InnerObject.innerFunction()
}

// Hasil Program 

Outer Function
Accessing Inner Object from Outer Class:
Outer Property: Outer Property
Inner Function
Inner Function


// COMPANION OBJECT

Companion object adalah kemampuan membuat inner object di dalam class, tanpa harus menggunakan nama Object
class Logger private constructor() {
    companion object {
        fun logMessage(message: String) {
            println("LOG: $message")
        }
    }
}

fun main() {
    Logger.logMessage("Hello, companion object!")
}

// Hasil Program 
LOG: Hello, companion object!


