package com.saydullin.duplifind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.saydullin.duplifind.presentation.screens.GameScene
import com.saydullin.duplifind.presentation.ui.theme.DupliFindTheme
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DupliFindTheme {
                GameScene(
                    gameViewModel = gameViewModel
                )
            }
        }
    }

}


