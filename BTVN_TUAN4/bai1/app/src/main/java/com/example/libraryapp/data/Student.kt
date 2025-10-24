package com.example.libraryapp.data

data class Student(
    val id: Int,
    val name: String,
    val borrowedBooks: List<Book> = emptyList()
)
//Danh sách các quyển sách mà sinh viên đang mượn.
//Mặc định là emptyList() để tránh lỗi NullPointerException khi sinh viên chưa mượn sách nào.