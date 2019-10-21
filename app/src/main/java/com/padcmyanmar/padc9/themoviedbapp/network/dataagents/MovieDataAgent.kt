package com.padcmyanmar.padc9.themoviedbapp.network.dataagents

import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieDetailVO
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

interface MovieDataAgent {

    fun getTopRatedMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPopularMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getNowPlayingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getUpComingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

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
}