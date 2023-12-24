package com.saydullin.duplifind.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.duplifind.presentation.components.CoinView
import com.saydullin.duplifind.presentation.components.GameTable
import com.saydullin.duplifind.presentation.components.TimerView
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun GameScene(
    navController: NavController = rememberNavController(),
    gameViewModel: GameViewModel = hiltViewModel(),
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TimerView(gameViewModel = gameViewModel)
            CoinView(gameViewModel = gameViewModel)
        }
        GameTable(
            navController = navController,
            gameViewModel = gameViewModel,
            onGameOver = {
                gameViewModel.setGameOver(true)
            }
        )
    }

}





