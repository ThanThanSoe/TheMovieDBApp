package com.padcmyanmar.padc9.themoviedbapp.mvp.views

import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

interface MovieSearchView: BaseView {
    fun displayMovieList(movies: List<MovieVO>)
    fun diplsayResultNotFound(message: String)
}