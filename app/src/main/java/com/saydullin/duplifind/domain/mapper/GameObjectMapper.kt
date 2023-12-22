package com.saydullin.duplifind.domain.mapper

import com.saydullin.duplifind.data.db.entity.GameObjectEntity
import com.saydullin.duplifind.domain.model.GameObject
import javax.inject.Inject

class GameObjectMapper @Inject constructor()
    : Mapper<GameObjectEntity, GameObject>() {

    override fun map(from: GameObjectEntity): GameObject {
        return GameObject(
            id = from.id,
            src = from.src,
            title = from.title,
            isHidden = from.isHidden,
        )
    }

}