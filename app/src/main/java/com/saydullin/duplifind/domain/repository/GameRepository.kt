package com.saydullin.duplifind.domain.repository

import com.saydullin.duplifind.data.db.dao.GameDao
import com.saydullin.duplifind.domain.mapper.GameMainEntityMapper
import com.saydullin.duplifind.domain.mapper.GameMainMapper
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.utils.Resource

interface GameRepository {

    val gameDao: GameDao
    val gameMainMapper: GameMainMapper
    val gameMainEntityMapper: GameMainEntityMapper

    suspend fun getGame(): Resource<GameMain>

    suspend fun saveGame(gameMain: GameMain): Resource<Unit>

}