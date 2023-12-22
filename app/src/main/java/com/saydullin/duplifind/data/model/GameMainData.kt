package com.saydullin.duplifind.data.model

data class GameMainData(
    val id: Int,
    val expiredSeconds: Int,
    val items: List<GameObjectData>,
    val coins: Int,
)


