package com.saydullin.duplifind.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.saydullin.duplifind.R
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel
import kotlinx.coroutines.delay

fun formatSecondsToMinutes(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60

    return String.format("%02d:%02d", minutes, remainingSeconds)
}

@Composable
fun TimerView(
    gameViewModel: GameViewModel = hiltViewModel(),
    onSecondPass: (seconds: Int) -> Unit
) {
    val seconds = remember { mutableIntStateOf(0) }
    val isRunning = remember { mutableStateOf(!gameViewModel.isGameOver.value) }

    LaunchedEffect(seconds.intValue, isRunning.value) {
        while (isRunning.value) {
            onSecondPass(seconds.intValue)
            delay(1000)
            seconds.intValue++
        }
    }

    Row(
        modifier = Modifier
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(30.dp)
                .height(30.dp),
            painter = painterResource(R.drawable.timer),
            contentDescription = stringResource(R.string.timer_cd)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 7.dp, horizontal = 20.dp),
                text = formatSecondsToMinutes(seconds.intValue),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }

}


