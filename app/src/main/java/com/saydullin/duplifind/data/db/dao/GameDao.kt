package com.saydullin.duplifind.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.duplifind.data.db.entity.GameMainEntity

@Dao
interface GameDao {

    @Query("SELECT * FROM GameMainEntity")
    fun getGame(): GameMainEntity

    @Insert(GameMainEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveGame(gameMainEntity: GameMainEntity)

}