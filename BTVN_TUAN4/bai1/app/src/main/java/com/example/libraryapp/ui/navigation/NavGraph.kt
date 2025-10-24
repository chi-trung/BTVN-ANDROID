package com.example.libraryapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.libraryapp.ui.LibraryViewModel
import com.example.libraryapp.ui.screens.ManageScreen
import com.example.libraryapp.ui.screens.BookListScreen
import com.example.libraryapp.ui.screens.StudentScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: LibraryViewModel,
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = "manage",
        modifier = Modifier.padding(innerPadding)
    ) {
        composable("manage") { ManageScreen(navController, viewModel) }
        composable("books") { BookListScreen(navController, viewModel) }
        composable("students") { StudentScreen(navController, viewModel) }
    }
}
