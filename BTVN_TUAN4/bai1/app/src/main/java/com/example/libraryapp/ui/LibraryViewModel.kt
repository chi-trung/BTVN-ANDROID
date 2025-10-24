package com.example.libraryapp.ui

import androidx.lifecycle.ViewModel
import com.example.libraryapp.data.Book
import com.example.libraryapp.data.LibraryRepository
import com.example.libraryapp.data.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LibraryViewModel : ViewModel() {
    private val repo = LibraryRepository()

    private val _students = MutableStateFlow<List<Student>>(repo.getStudents())
    val students: StateFlow<List<Student>> = _students.asStateFlow()

    private val _currentStudent = MutableStateFlow<Student?>(repo.getStudents().firstOrNull())
    val currentStudent: StateFlow<Student?> = _currentStudent.asStateFlow()

    fun changeStudent(name: String) {
        val student = repo.getStudents().find { it.name == name }
        _currentStudent.value = student
    }

    fun addBookToCurrentStudent(book: Book) {
        val student = _currentStudent.value ?: return
        if (student.borrowedBooks.none { it.id == book.id }) {
            val updatedStudent = student.copy(
                borrowedBooks = student.borrowedBooks + book
            )
            repo.updateStudent(updatedStudent)

            // Cập nhật lại danh sách students tổng
            val updatedList = _students.value.map {
                if (it.id == updatedStudent.id) updatedStudent else it
            }

            _students.value = updatedList
            _currentStudent.value = updatedStudent
        }
    }
    fun removeBookFromCurrentStudent(book: Book) {
        val student = _currentStudent.value ?: return

        // Tạo bản sao mới của sinh viên sau khi xóa sách khỏi danh sách mượn
        val updatedStudent = student.copy(
            borrowedBooks = student.borrowedBooks.filterNot { it.id == book.id }
        )

        // Cập nhật repository
        repo.updateStudent(updatedStudent)

        // Cập nhật lại danh sách sinh viên và sinh viên hiện tại trong ViewModel
        _students.value = _students.value.map {
            if (it.id == updatedStudent.id) updatedStudent else it
        }
        _currentStudent.value = updatedStudent
    }
}
