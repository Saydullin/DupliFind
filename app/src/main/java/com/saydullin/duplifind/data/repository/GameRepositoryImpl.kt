package com.saydullin.duplifind.data.repository

import com.saydullin.duplifind.data.db.dao.GameDao
import com.saydullin.duplifind.domain.mapper.GameMainEntityMapper
import com.saydullin.duplifind.domain.mapper.GameMainMapper
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.repository.GameRepository
import com.saydullin.duplifind.domain.utils.Resource
import com.saydullin.duplifind.domain.utils.StatusType
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    override val gameDao: GameDao,
    override val gameMainMapper: GameMainMapper,
    override val gameMainEntityMapper: GameMainEntityMapper,
): GameRepository {

    override suspend fun getGame(): Resource<GameMain> {
        return try {
            val game = gameDao.getGame()
            val gameMapped = gameMainMapper.map(game)
            Resource.Success(gameMapped)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(statusType = StatusType.DATABASE_ERROR)
        }
    }

    override suspend fun saveGame(gameMain: GameMain): Resource<Unit> {
        return try {
            val gameMainEntity = gameMainEntityMapper.map(gameMain)
            gameDao.saveGame(gameMainEntity)
            Resource.Success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(statusType = StatusType.DATABASE_ERROR)
        }
    }

}


