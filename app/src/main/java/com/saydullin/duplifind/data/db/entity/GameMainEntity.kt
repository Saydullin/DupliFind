package com.saydullin.duplifind.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameMainEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val expiredSeconds: Int,
    val items: List<GameObjectEntity>,
    val coins: Int,
)


