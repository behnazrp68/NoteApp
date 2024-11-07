package com.rajabi.noteapp.presentation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = "note_screen"
    ) {
        composable(route = "note_screen"){
            NoteAppScreen()
        }
    }
}