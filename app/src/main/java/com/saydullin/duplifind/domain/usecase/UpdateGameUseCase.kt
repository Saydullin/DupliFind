package com.saydullin.duplifind.domain.usecase

import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.model.GameObject
import com.saydullin.duplifind.domain.repository.GameRepository
import com.saydullin.duplifind.domain.utils.Resource
import javax.inject.Inject

class UpdateGameUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {

    suspend fun execute(gameMain: GameMain, gameObject: GameObject): Resource<Unit> {
        return gameRepository.updateGame(gameMain, gameObject)
    }

}


