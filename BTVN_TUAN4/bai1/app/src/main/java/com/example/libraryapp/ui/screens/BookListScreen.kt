package com.example.libraryapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.libraryapp.data.Book
import com.example.libraryapp.ui.LibraryViewModel
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(navController: NavController, viewModel: LibraryViewModel) {
    val students by viewModel.students.collectAsState()
    val currentStudent by viewModel.currentStudent.collectAsState()

    if (currentStudent == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Chưa chọn sinh viên nào.")
        }
        return
    }

    val borrowedBooks = currentStudent!!.borrowedBooks
    val allBooks = students.flatMap { it.borrowedBooks }.distinctBy { it.id }
    val availableBooks = listOf(
        Book(1, "Kotlin cơ bản"),
        Book(2, "Android nâng cao"),
        Book(3, "Lập trình Compose"),
        Book(4, "Cơ sở dữ liệu SQL"),
        Book(5, "Clean Code")
    ).filterNot { b -> borrowedBooks.any { it.id == b.id } }

    var selectedBooks by remember { mutableStateOf(setOf<Book>()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📘 Chọn Sách") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (availableBooks.isEmpty()) {
                Text("Tất cả sách đã được mượn.", color = MaterialTheme.colorScheme.error)
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    items(availableBooks) { book ->
                        ElevatedCard(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.elevatedCardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(book.title)
                                Checkbox(
                                    checked = selectedBooks.contains(book),
                                    onCheckedChange = { checked ->
                                        selectedBooks = if (checked)
                                            selectedBooks + book
                                        else
                                            selectedBooks - book
                                    }
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    selectedBooks.forEach { viewModel.addBookToCurrentStudent(it) }
                    navController.navigate("manage")
                },
                enabled = selectedBooks.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Icon(Icons.Default.Check, contentDescription = "Confirm")
                Spacer(Modifier.width(8.dp))
                Text("Xác nhận mượn")
            }
        }
    }
}
