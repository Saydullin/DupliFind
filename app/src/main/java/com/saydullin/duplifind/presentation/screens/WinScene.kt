package com.saydullin.duplifind.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun WinScene(
    navController: NavController = rememberNavController(),
    gameViewModel: GameViewModel = hiltViewModel(),
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Congratulations, you win!",
            style = MaterialTheme.typography.titleLarge
        )
    }

}