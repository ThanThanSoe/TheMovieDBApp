package com.padcmyanmar.padc9.themoviedbapp.mvp.views

import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

interface MovieListView: BaseView {
    fun displayTopRatedMovieList(movies: List<MovieVO>)
    fun displayPopularMovieList(movies: List<MovieVO>)
    fun displayUpcomingMovieList(movies: List<MovieVO>)
    fun displayNowPlayingMovieList(movies: List<MovieVO>)

    fun displayErrorMessage(errorMessage: String)
}