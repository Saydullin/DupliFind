package com.saydullin.duplifind.di

import android.content.Context
import androidx.room.Room
import com.saydullin.duplifind.data.db.AppDatabase
import com.saydullin.duplifind.data.db.converter.GameItemsConverter
import com.saydullin.duplifind.data.db.dao.GameDao
import com.saydullin.duplifind.data.repository.GameRepositoryImpl
import com.saydullin.duplifind.domain.mapper.GameMainEntityMapper
import com.saydullin.duplifind.domain.mapper.GameMainMapper
import com.saydullin.duplifind.domain.mapper.Mapper
import com.saydullin.duplifind.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "DupliFinDatabase"
        )
            .allowMainThreadQueries()
            .addTypeConverter(GameItemsConverter())
            .build()
    }

    @Provides
    @Singleton
    fun provideGameDao(appDatabase: AppDatabase): GameDao {
        return appDatabase.gameDao()
    }

    @Provides
    @Singleton
    fun provideGameRepository(
        gameDao: GameDao,
        gameMainMapper: GameMainMapper,
        gameMainEntityMapper: GameMainEntityMapper,
    ): GameRepository {
        return GameRepositoryImpl(
            gameDao = gameDao,
            gameMainMapper = gameMainMapper,
            gameMainEntityMapper = gameMainEntityMapper,
        )
    }

}