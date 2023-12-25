package com.saydullin.duplifind.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.saydullin.duplifind.R
import com.saydullin.duplifind.presentation.components.CoinView
import com.saydullin.duplifind.presentation.components.GameTable
import com.saydullin.duplifind.presentation.components.TimerView
import com.saydullin.duplifind.presentation.navigation.Screen
import com.saydullin.duplifind.presentation.utils.GamePriceController
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun GameScene(
    navController: NavController = rememberNavController(),
    gameViewModel: GameViewModel = hiltViewModel(),
) {

    val coins = gameViewModel.game.value?.coins ?: 0
    var secondsPassed = 0

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
            TimerView(
                gameViewModel = gameViewModel,
                onSecondPass = {
                    secondsPassed = it
                }
            )
            CoinView(gameViewModel = gameViewModel)
        }
        Spacer(modifier = Modifier.height(10.dp))
        GameTable(
            gameViewModel = gameViewModel,
            onGameOver = {
                gameViewModel.setGameOver(true)
                val price = GamePriceController.getPriceAmount(secondsPassed)
                gameViewModel.setCoins(coins + price)
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(Screen.Home.route, true)
                    .build()

                navController.navigate(Screen.WinScene.route, navOptions)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .alpha(.7f),
            text = stringResource(R.string.game_hint),
            style = MaterialTheme.typography.titleMedium
        )
    }

}


