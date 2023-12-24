package com.saydullin.duplifind.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.duplifind.R
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.presentation.components.CoinView
import com.saydullin.duplifind.presentation.navigation.Screen
import com.saydullin.duplifind.presentation.utils.GameController
import com.saydullin.duplifind.presentation.viewmodel.CoinViewModel
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    gameViewModel: GameViewModel = hiltViewModel()
) {

    LaunchedEffect(Dispatchers.IO) {
        gameViewModel.getGame()
    }

    val createNewGame = {
        val gameController = GameController()
        val newGameObjects = gameController.getGameObjects()
        val newGame = GameMain(
            expiredSeconds = 0,
            items = newGameObjects,
            coins = 100,
        )
        gameViewModel.saveGame(newGame)
        navController.navigate(Screen.GameScene.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            CoinView(
                gameViewModel = gameViewModel
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .padding(horizontal = 10.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = stringResource(R.string.coin_cd)
                )

                Button(
                    modifier = Modifier
                        .padding(20.dp),
                    onClick = { createNewGame() }
                ) {
                    Text(
                        text = stringResource(R.string.play),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Image(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(horizontal = 10.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = stringResource(R.string.coin_cd)
                )
            }
        }

    }

}


