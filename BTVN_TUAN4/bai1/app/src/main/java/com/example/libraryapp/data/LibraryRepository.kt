package com.example.libraryapp.data
class LibraryRepository {
    private val students = mutableListOf(
        Student(1, "Nguyễn Văn A", listOf(Book(1, "Kotlin cơ bản"))),
        Student(2, "Trần Thị B", listOf(Book(2, "Android nâng cao")))
    )

    fun getStudents(): List<Student> = students

    fun updateStudent(updated: Student) {
        val index = students.indexOfFirst { it.id == updated.id }
        if (index != -1) students[index] = updated
    }
}
