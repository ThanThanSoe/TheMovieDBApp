package com.padcmyanmar.padc9.themoviedbapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO
import com.padcmyanmar.padc9.themoviedbapp.persistence.daos.MovieDao
import com.padcmyanmar.padc9.themoviedbapp.persistence.typeconverters.GenreIdsTypeConverter
import com.padcmyanmar.padc9.themoviedbapp.utils.MOVIE_DB

@Database(entities = [MovieVO::class], version = 1, exportSchema = false)
@TypeConverters(GenreIdsTypeConverter::class)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MovieDatabase::class.java, MOVIE_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }
    }

}