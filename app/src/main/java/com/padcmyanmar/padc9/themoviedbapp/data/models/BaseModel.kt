package com.padcmyanmar.padc9.themoviedbapp.data.models

import android.content.Context
import com.padcmyanmar.padc9.themoviedbapp.network.dataagents.RetrofitMovieDataAgentImpl
import com.padcmyanmar.padc9.themoviedbapp.persistence.MovieDatabase

abstract class BaseModel {
    protected val movieDataAgent = RetrofitMovieDataAgentImpl

    companion object {
        lateinit var movieDatabase: MovieDatabase

        fun initDatabase(context: Context) {
            this.movieDatabase = MovieDatabase.getInstance(context)
        }
    }
}