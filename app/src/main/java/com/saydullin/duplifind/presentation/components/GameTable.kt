package com.saydullin.duplifind.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.model.GameObject
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun GameTable(
    gameViewModel: GameViewModel = hiltViewModel()
) {

    val game = gameViewModel.game.value
    val context = LocalContext.current
    val selectedObject = remember {
        mutableStateOf<GameObject?>(null)
    }

    val onClickObject = { gameMain: GameMain, currentObject: GameObject ->
        var isSelectedNow = false
        if (selectedObject.value == null) {
            selectedObject.value = currentObject
            isSelectedNow = true
        }
        if (selectedObject.value != null && selectedObject.value?.title == currentObject.title) {
            val isNotHidden = currentObject.copy(
                isHidden = false
            )
            gameViewModel.updateGame(gameMain, isNotHidden)
            selectedObject.value = currentObject
        }
        if (selectedObject.value == currentObject && !isSelectedNow) {
            selectedObject.value = null
        }
    }

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        columns = GridCells.Adaptive(70.dp)
    ) {
        if (game != null) {
            items(game.items) {
                GameObject(
                    gameObject = it,
                    onClick = { onClickObject(game, it) }
                )
            }
        }
    }

}


