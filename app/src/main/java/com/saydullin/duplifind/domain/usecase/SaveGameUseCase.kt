package com.saydullin.duplifind.domain.usecase

import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.repository.GameRepository
import com.saydullin.duplifind.domain.utils.Resource
import javax.inject.Inject

class SaveGameUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {

    suspend fun execute(gameMain: GameMain): Resource<Unit> {
        return gameRepository.saveGame(gameMain)
    }

}