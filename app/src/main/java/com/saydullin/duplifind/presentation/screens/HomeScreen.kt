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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.duplifind.R
import com.saydullin.duplifind.presentation.components.CoinView

@Composable
fun HomeScreen() {

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
            CoinView()
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
                    onClick = { /*TODO*/ }
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