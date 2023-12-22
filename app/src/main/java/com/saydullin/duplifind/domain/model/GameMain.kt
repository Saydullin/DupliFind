package com.saydullin.duplifind.domain.model

data class GameMain(
    val id: Int,
    val expiredSeconds: Int,
    val items: List<GameObject>,
    val coins: Int,
)


