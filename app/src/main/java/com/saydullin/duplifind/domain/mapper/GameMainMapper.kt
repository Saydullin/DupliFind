package com.saydullin.duplifind.domain.mapper

import com.saydullin.duplifind.data.db.entity.GameMainEntity
import com.saydullin.duplifind.domain.model.GameMain
import javax.inject.Inject

class GameMainMapper @Inject constructor(
    private val gameObjectMapper: GameObjectMapper
): Mapper<GameMainEntity, GameMain>() {

    override fun map(from: GameMainEntity): GameMain {
        return GameMain(
            id = from.id,
            expiredSeconds = from.expiredSeconds,
            items = from.items.map { gameObjectMapper.map(it) },
            coins = from.coins,
        )
    }

}