package com.example.libraryapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.libraryapp.ui.LibraryViewModel
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageScreen(navController: NavController, viewModel: LibraryViewModel) {
    val students by viewModel.students.collectAsState()
    val currentStudent by viewModel.currentStudent.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📚 Library Manager") },
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
            if (students.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Chưa có sinh viên nào trong hệ thống.", color = Color.Gray)
                }
                return@Column
            }

            var expanded by remember { mutableStateOf(false) }
            var name by remember(currentStudent?.name) { mutableStateOf(currentStudent?.name ?: "") }
            val borrowedBooks = currentStudent?.borrowedBooks ?: emptyList()

            Text("Sinh viên", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Chọn sinh viên") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    students.forEach { student ->
                        DropdownMenuItem(
                            text = { Text(student.name) },
                            onClick = {
                                name = student.name
                                expanded = false
                                viewModel.changeStudent(student.name)
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Danh sách sách đã mượn", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    if (borrowedBooks.isEmpty()) {
                        Text(
                            text = "Bạn chưa mượn quyển sách nào.\nNhấn 'Thêm' để bắt đầu hành trình đọc sách!",
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                    } else {
                        borrowedBooks.forEach { book ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                var checked by remember { mutableStateOf(true) }
                                Checkbox(
                                    checked = checked,
                                    onCheckedChange = { isChecked ->
                                        checked = isChecked
                                        if (!isChecked) viewModel.removeBookFromCurrentStudent(book)
                                    }
                                )
                                Text(book.title)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { if (currentStudent != null) navController.navigate("books") },
                enabled = currentStudent != null,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add book")
                Spacer(Modifier.width(8.dp))
                Text("Thêm Sách")
            }
        }
    }
}
