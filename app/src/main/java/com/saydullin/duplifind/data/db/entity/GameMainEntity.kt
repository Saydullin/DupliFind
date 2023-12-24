package com.saydullin.duplifind.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameMainEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    val expiredSeconds: Int,
    val items: List<GameObjectEntity>,
    val coins: Int,
)


