package com.saydullin.duplifind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.duplifind.presentation.components.CoinView
import com.saydullin.duplifind.presentation.screens.HomeScreen
import com.saydullin.duplifind.presentation.ui.theme.DupliFindTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DupliFindTheme {
                HomeScreen()
            }
        }
    }

}


