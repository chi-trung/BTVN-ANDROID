package com.example.libraryapp.data

data class Book(
    val id: Int,
    val title: String,
    var isBorrowed: Boolean = false// Trạng thái mượn (mặc định là chưa mượn)
)
