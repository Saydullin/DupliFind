package com.saydullin.duplifind.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saydullin.duplifind.data.db.converter.GameItemsConverter
import com.saydullin.duplifind.data.db.dao.GameDao
import com.saydullin.duplifind.data.db.entity.GameMainEntity

@Database(
    entities = [
        GameMainEntity::class
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    GameItemsConverter::class,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

}