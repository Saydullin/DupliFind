package com.saydullin.duplifind.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.saydullin.duplifind.presentation.viewmodel.CoinViewModel

@Composable
fun CoinView(
    modifier: Modifier = Modifier,
    coinViewModel: CoinViewModel = hiltViewModel()
) {

    val coin = coinViewModel.coin.intValue

    Row(
        modifier = modifier
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .padding(horizontal = 10.dp),
            painter = painterResource(R.drawable.coin),
            contentDescription = stringResource(R.string.coin_cd)
        )
        Text(
            text = "$coin",
            style = MaterialTheme.typography.titleLarge
        )
    }

}


