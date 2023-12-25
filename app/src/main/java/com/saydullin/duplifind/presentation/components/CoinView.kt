package com.saydullin.duplifind.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.saydullin.duplifind.R
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun CoinView(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel = hiltViewModel()
) {

    val coin = gameViewModel.game.value?.coins

    Row(
        modifier = modifier
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .width(45.dp)
                .height(45.dp)
                .padding(horizontal = 10.dp),
            painter = painterResource(R.drawable.coin),
            contentDescription = stringResource(R.string.coin_cd)
        )
        Text(
            text = if (coin == null) stringResource(R.string.no_coin_found) else "$coin",
            style = MaterialTheme.typography.titleLarge
        )
    }

}


