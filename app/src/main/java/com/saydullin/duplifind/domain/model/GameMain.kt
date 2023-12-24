package com.saydullin.duplifind.domain.model

data class GameMain(
    val id: Int = 0,
    val expiredSeconds: Int,
    val items: List<GameObject>,
    val coins: Int,
)


