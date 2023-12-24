package com.saydullin.duplifind.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.presentation.components.GameTable
import com.saydullin.duplifind.presentation.utils.GameController
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun GameScene(
    gameViewModel: GameViewModel = hiltViewModel(),
) {

    LaunchedEffect(Dispatchers.IO) {
        gameViewModel.getGame()
        val game = gameViewModel.game.value

        if (game == null) {
            val gameController = GameController()
            val newGameObjects = gameController.getGameObjects()
            val newGame = GameMain(
                expiredSeconds = 0,
                items = newGameObjects,
                coins = 100,
            )
            gameViewModel.saveGame(newGame)
        }
    }

    GameTable(
        gameViewModel = gameViewModel
    )

}


