package com.padcmyanmar.padc9.themoviedbapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreIdsTypeConverter {

    @TypeConverter
    fun toString(list: List<Int> ) : String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json: String): List<Int> {
        var typeToken = object : TypeToken<List<Int>>(){}.type
        return Gson().fromJson(json, typeToken)
    }
}