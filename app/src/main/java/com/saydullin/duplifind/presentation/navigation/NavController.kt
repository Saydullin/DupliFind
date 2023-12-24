package com.saydullin.duplifind.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saydullin.duplifind.presentation.screens.GameScene
import com.saydullin.duplifind.presentation.screens.HomeScreen
import com.saydullin.duplifind.presentation.screens.WinScene
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun NavController(
    gameViewModel: GameViewModel = hiltViewModel(),
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController,
                gameViewModel = gameViewModel
            )
        }
        composable(Screen.GameScene.route) {
            GameScene(
                navController = navController,
                gameViewModel = gameViewModel
            )
        }
        composable(Screen.WinScene.route) {
            WinScene(
                navController = navController,
                gameViewModel = gameViewModel
            )
        }
    }

}


