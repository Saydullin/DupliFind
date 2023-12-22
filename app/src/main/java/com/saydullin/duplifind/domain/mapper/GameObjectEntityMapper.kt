package com.saydullin.duplifind.domain.mapper

import com.saydullin.duplifind.data.db.entity.GameObjectEntity
import com.saydullin.duplifind.domain.model.GameObject
import javax.inject.Inject

class GameObjectEntityMapper @Inject constructor()
    : Mapper<GameObject, GameObjectEntity>() {

    override fun map(from: GameObject): GameObjectEntity {
        return GameObjectEntity(
            id = from.id,
            src = from.src,
            title = from.title,
            isHidden = from.isHidden,
        )
    }

}


