package com.saydullin.duplifind.data.db.entity

import androidx.room.Entity

@Entity
data class GameObjectEntity(
    val id: Int,
    val src: Int,
    val title: String,
    val isHidden: Boolean,
)


