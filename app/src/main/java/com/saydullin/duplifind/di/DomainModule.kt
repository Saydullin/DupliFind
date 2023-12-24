package com.saydullin.duplifind.di

import com.saydullin.duplifind.domain.repository.GameRepository
import com.saydullin.duplifind.domain.usecase.GetGameUseCase
import com.saydullin.duplifind.domain.usecase.SaveGameUseCase
import com.saydullin.duplifind.domain.usecase.UpdateGameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetGameUseCase(
        gameRepository: GameRepository
    ): GetGameUseCase {
        return GetGameUseCase(
            gameRepository = gameRepository
        )
    }

    @Provides
    fun provideSaveGameUseCase(
        gameRepository: GameRepository
    ): SaveGameUseCase {
        return SaveGameUseCase(
            gameRepository = gameRepository
        )
    }

    @Provides
    fun provideUpdateGameUseCase(
        gameRepository: GameRepository
    ): UpdateGameUseCase {
        return UpdateGameUseCase(
            gameRepository = gameRepository
        )
    }

}


