package com.saydullin.duplifind.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.usecase.GetGameUseCase
import com.saydullin.duplifind.domain.usecase.SaveGameUseCase
import com.saydullin.duplifind.domain.utils.Resource
import com.saydullin.duplifind.domain.utils.StatusType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGameUseCase: GetGameUseCase,
    private val saveGameUseCase: SaveGameUseCase
): ViewModel() {

    private val _game = mutableStateOf<GameMain?>(null)
    private val _error = mutableStateOf<StatusType?>(null)
    val game = _game
    val error = _error

    fun getGame() {
        viewModelScope.launch(Dispatchers.IO) {
            val game = getGameUseCase.execute()
            if (game is Resource.Success && game.data != null) {
                _game.value = game.data
            } else {
                _game.value = null
                _error.value = game.statusType
            }
        }
    }

    fun saveGame(gameMain: GameMain) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = saveGameUseCase.execute(gameMain)
            if (response is Resource.Error || response.data == null) {
                _error.value = response.statusType
            }
        }
    }

}


