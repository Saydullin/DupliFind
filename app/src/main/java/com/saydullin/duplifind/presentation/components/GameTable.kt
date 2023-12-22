package com.saydullin.duplifind.presentation.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.saydullin.duplifind.presentation.viewmodel.GameViewModel

@Composable
fun GameTable(
    gameViewModel: GameViewModel = hiltViewModel()
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(4)
    ) {

    }

}