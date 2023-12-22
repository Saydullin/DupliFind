package com.saydullin.duplifind.data.db.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.saydullin.duplifind.data.db.entity.GameObjectEntity

@ProvidedTypeConverter
class GameItemsConverter {

    @TypeConverter
    fun fromGameItemsToString(items: List<GameObjectEntity>?): String? {
        return Gson().toJson(items)
    }

    @TypeConverter
    fun fromStringToGameItems(items: String): List<GameObjectEntity>? {
        val listType = object: TypeToken<List<GameObjectEntity>>(){}.type
        return Gson().fromJson(items, listType)
    }

}