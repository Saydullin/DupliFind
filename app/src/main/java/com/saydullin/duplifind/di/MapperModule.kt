package com.saydullin.duplifind.di

import com.saydullin.duplifind.data.db.entity.GameMainEntity
import com.saydullin.duplifind.data.db.entity.GameObjectEntity
import com.saydullin.duplifind.domain.mapper.GameMainEntityMapper
import com.saydullin.duplifind.domain.mapper.GameMainMapper
import com.saydullin.duplifind.domain.mapper.GameObjectEntityMapper
import com.saydullin.duplifind.domain.mapper.GameObjectMapper
import com.saydullin.duplifind.domain.mapper.Mapper
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.model.GameObject
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindGameMainEntityMapper(
        mapper: GameMainEntityMapper
    ): Mapper<GameMain, GameMainEntity>

    @Binds
    abstract fun bindGamMainMapper(
        mapper: GameMainMapper
    ): Mapper<GameMainEntity, GameMain>

    @Binds
    abstract fun bindGameObjectEntityMapper(
        mapper: GameObjectEntityMapper
    ): Mapper<GameObject, GameObjectEntity>

    @Binds
    abstract fun bindGameObjectMapper(
        mapper: GameObjectMapper
    ): Mapper<GameObjectEntity, GameObject>

}