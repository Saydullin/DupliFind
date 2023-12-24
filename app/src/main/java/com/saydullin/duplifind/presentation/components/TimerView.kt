package com.saydullin.duplifind.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel
import kotlinx.coroutines.delay

fun formatSecondsToMinutes(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60

    return String.format("%02d:%02d", minutes, remainingSeconds)
}

@Composable
fun TimerView(
    gameViewModel: GameViewModel = hiltViewModel()
) {
    val seconds = remember { mutableIntStateOf(0) }
    val isRunning = remember { mutableStateOf(!gameViewModel.isGameOver.value) }

    LaunchedEffect(seconds.intValue, isRunning.value) {
        while (isRunning.value) {
            delay(1000)
            seconds.intValue++
        }
    }

    Column(
        modifier = Modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatSecondsToMinutes(seconds.intValue),
            style = MaterialTheme.typography.titleLarge
        )
    }

}


