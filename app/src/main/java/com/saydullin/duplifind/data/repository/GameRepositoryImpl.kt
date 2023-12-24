package com.saydullin.duplifind.data.repository

import com.saydullin.duplifind.data.db.dao.GameDao
import com.saydullin.duplifind.domain.mapper.GameMainEntityMapper
import com.saydullin.duplifind.domain.mapper.GameMainMapper
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.model.GameObject
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
            val sortedGame = gameMapped.copy(
                items = gameMapped.items.sortedBy { it.id }
            )
            Resource.Success(sortedGame)
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

    override suspend fun updateGame(gameMain: GameMain, gameObject: GameObject): Resource<Unit> {
        return try {
            val gameItems = ArrayList(gameMain.items)
            val gameObjectIndex = gameMain.items.indexOfFirst { it.id == gameObject.id }
            if (gameObjectIndex != -1) {
                gameItems[gameObjectIndex] = gameObject
            }
            val newGameMain = gameMain.copy(
                items = gameItems
            )
            val gameMainEntity = gameMainEntityMapper.map(newGameMain)
            gameDao.saveGame(gameMainEntity)
            Resource.Success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

}


