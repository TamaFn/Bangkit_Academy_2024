// Bedanya adalah inner class mengakses properties dan variable dari outer class

// Nested Class

class House(val address: String) {
    // Nested class Room
    class Room(val name: String, val area: Double) {
        fun displayInfo() {
            println("Room: $name, Area: $area square meters")
        }
    }

    // Fungsi untuk menampilkan info rumah dan ruangan
    fun displayHouseInfo() {
        println("House Address: $address")
        // Membuat objek dari nested class Room
        val livingRoom = Room("Living Room", 30.0)
        val kitchen = Room("Kitchen", 20.0)

        // Menampilkan info ruangan
        livingRoom.displayInfo()
        kitchen.displayInfo()
    }
}

fun main() {
    // Membuat objek dari class House
    val myHouse = House("123 Main Street")
    // Menampilkan info rumah dan ruangan
    myHouse.displayHouseInfo()
}


// Hasil Program 
House Address: 123 Main Street
Room: Living Room, Area: 30.0 square meters
Room: Kitchen, Area: 20.0 square meters

//  Inner Class

class School(val schoolName: String) {
    private val schoolLocation: String = "City A"

    // Inner class untuk ruangan di sekolah
    inner class Classroom(val className: String, val capacity: Int) {
        fun displayClassInfo() {
            println("Classroom $className, Capacity: $capacity students")
            println("Located in: $schoolLocation")
        }
    }

    // Inner class untuk murid
    inner class Student(val studentName: String, val grade: Int) {
        fun displayStudentInfo() {
            println("Student: $studentName, Grade: $grade")
            println("School: $schoolName")
        }
    }

    fun displaySchoolInfo() {
        println("School Name: $schoolName")
        println("Located in: $schoolLocation")
    }
}

fun main() {
    val mySchool = School("ABC High School")

    // Membuat objek dari inner class Classroom
    val classroomA = mySchool.Classroom("A101", 30)
    val classroomB = mySchool.Classroom("B202", 25)

    // Memanggil fungsi dari inner class Classroom
    classroomA.displayClassInfo()
    classroomB.displayClassInfo()

    // Membuat objek dari inner class Student
    val student1 = mySchool.Student("Alice", 11)
    val student2 = mySchool.Student("Bob", 10)

    // Memanggil fungsi dari inner class Student
    student1.displayStudentInfo()
    student2.displayStudentInfo()

    // Memanggil fungsi dari outer class School
    mySchool.displaySchoolInfo()
}

// Hasil Program
Classroom A101, Capacity: 30 students
Located in: City A
Classroom B202, Capacity: 25 students
Located in: City A
Student: Alice, Grade: 11
School: ABC High School
Student: Bob, Grade: 10
School: ABC High School
School Name: ABC High School
Located in: City A

// Pengguaan this bila memiliki properties yang sama 
class School(val schoolName: String) {
    private val location: String = "City A"

    // Inner class
    inner class Classroom(val className: String, val capacity: Int) {
        private val location: String = "Building A"

        fun displayClassInfo() {
            println("Classroom $className, Capacity: $capacity students")
            println("Inner Class Location: $location")
            println("Outer Class Location: ${this@School.location}")
        }
    }

    fun displaySchoolInfo() {
        println("School Name: $schoolName")
        println("Outer Class Location: $location")
    }
}

fun main() {
    val mySchool = School("ABC High School")

    // Membuat objek dari inner class Classroom
    val classroomA = mySchool.Classroom("A101", 30)

    // Memanggil fungsi dari inner class Classroom
    classroomA.displayClassInfo()

    // Memanggil fungsi dari outer class School
    mySchool.displaySchoolInfo()
}



