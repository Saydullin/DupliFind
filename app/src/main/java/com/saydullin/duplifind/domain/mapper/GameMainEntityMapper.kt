package com.saydullin.duplifind.domain.mapper

import com.saydullin.duplifind.data.db.entity.GameMainEntity
import com.saydullin.duplifind.domain.model.GameMain
import javax.inject.Inject

class GameMainEntityMapper @Inject constructor(
    private val gameObjectEntityMapper: GameObjectEntityMapper
): Mapper<GameMain, GameMainEntity>() {

    override fun map(from: GameMain): GameMainEntity {
        return GameMainEntity(
            id = from.id,
            expiredSeconds = from.expiredSeconds,
            items = from.items.map { gameObjectEntityMapper.map(it) },
            coins = from.coins,
        )
    }

}


