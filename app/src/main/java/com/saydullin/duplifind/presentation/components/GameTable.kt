package com.saydullin.duplifind.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.model.GameObject
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun GameTable(
    gameViewModel: GameViewModel = hiltViewModel(),
    onGameOver: () -> Unit
) {

    val game = gameViewModel.game.value
    val gameObjects = remember {
        mutableStateOf(game?.items ?: listOf())
    }
    val selectedObject = remember {
        mutableStateOf<GameObject?>(null)
    }

    val checkIfWin = {
        val openedObjects = gameObjects.value.filter { it.isHidden }

        if (openedObjects.isEmpty()) {
            onGameOver()
        }
    }

    val selectObjectUI = { currentObject: GameObject ->
        val gameItems = ArrayList(gameObjects.value)
        val clickedObjectId = gameItems.indexOfFirst { it.id == currentObject.id }
        gameItems[clickedObjectId] = currentObject.copy(
            isHidden = false
        )
        gameObjects.value = gameItems
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
            selectObjectUI(currentObject)
            selectedObject.value = currentObject
        }
        if (selectedObject.value == currentObject && !isSelectedNow) {
            selectedObject.value = null
        }
        checkIfWin()
    }

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        columns = GridCells.Adaptive(70.dp)
    ) {
        if (game != null) {
            items(gameObjects.value) {
                GameObject(
                    gameObject = it,
                    onClick = { onClickObject(game, it) }
                )
            }
        }
    }

}


