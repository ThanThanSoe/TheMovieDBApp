package com.padcmyanmar.padc9.themoviedbapp.mvp.views

import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieDetailVO
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

interface MovieDetailView: BaseView {
    fun displayMovieDetail(movieDetail: MovieDetailVO)
    fun displaySimilarMovies(movies: List<MovieVO>)
    fun errorDisplayDetail(errorMessage: String)
}