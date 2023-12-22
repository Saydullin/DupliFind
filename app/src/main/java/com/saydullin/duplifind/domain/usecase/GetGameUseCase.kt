package com.saydullin.duplifind.domain.usecase

import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.repository.GameRepository
import com.saydullin.duplifind.domain.utils.Resource
import javax.inject.Inject

class GetGameUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {

    suspend fun execute(): Resource<GameMain> {
        return gameRepository.getGame()
    }

}