package com.example.libraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.ui.LibraryViewModel
import com.example.libraryapp.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: LibraryViewModel = viewModel()
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    NavigationBar {
                        NavigationBarItem(
                            selected = true,
                            onClick = { navController.navigate("manage") },
                            label = { Text("Quản lý") },
                            icon = { Icon(Icons.Default.Home, contentDescription = null) }
                        )
                        NavigationBarItem(
                            selected = false,
                            onClick = { navController.navigate("books") },
                            label = { Text("DS Sách") },
                            icon = { Icon(Icons.Default.MenuBook, contentDescription = null) }
                        )
                        NavigationBarItem(
                            selected = false,
                            onClick = { navController.navigate("students") },
                            label = { Text("Sinh viên") },
                            icon = { Icon(Icons.Default.Person, contentDescription = null) }
                        )
                    }
                }
            ) { innerPadding ->
                NavGraph(
                    navController = navController,
                    viewModel = viewModel,
                    innerPadding = innerPadding
                )
            }
        }
    }
}
