package com.saydullin.duplifind.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.saydullin.duplifind.R
import com.saydullin.duplifind.presentation.components.CoinView
import com.saydullin.duplifind.presentation.navigation.Screen
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun WinScene(
    navController: NavController,
    gameViewModel: GameViewModel = hiltViewModel(),
) {

    val coins = gameViewModel.game.value?.coins ?: 0

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(horizontal = 10.dp),
                painter = painterResource(R.drawable.win),
                contentDescription = stringResource(R.string.win_cd)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Congratulations, you win!",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(30.dp))
            CoinView(gameViewModel = gameViewModel)
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    gameViewModel.setCoins(coins * 2)
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    text = stringResource(R.string.double_reward),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(Screen.Home.route, true)
                        .build()

                    navController.navigate(Screen.Home.route, navOptions)
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 3.dp),
                    text = stringResource(R.string.home),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }

}