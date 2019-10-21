package com.padcmyanmar.padc9.themoviedbapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveAll(movies: List<MovieVO>): LongArray

    @Query("SELECT * FROM movies")
    abstract fun all(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies ORDER BY vote_average DESC LIMIT 20")
    abstract fun topRated(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies ORDER BY popularity DESC LIMIT 20")
    abstract fun popular(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies WHERE upcoming=1")
    abstract fun upcoming(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies WHERE now_playing=1")
    abstract fun nowPlayng(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies WHERE title=:title")
    abstract fun search(title: String): LiveData<List<MovieVO>>
}