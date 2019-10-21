package com.padcmyanmar.padc9.themoviedbapp.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieDetailVO
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

interface MovieModel {
    fun getAllMovies(): LiveData<List<MovieVO>>
    fun getTopRatedMovies(): LiveData<List<MovieVO>>
    fun getPopularMovies(): LiveData<List<MovieVO>>
    fun getUpcomingMovies(): LiveData<List<MovieVO>>
    fun getNowPlayingMovies(): LiveData<List<MovieVO>>
    fun getMovieDetail(
        id: Int,
        onSuccess: (MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun search(title: String): LiveData<List<MovieVO>>
}