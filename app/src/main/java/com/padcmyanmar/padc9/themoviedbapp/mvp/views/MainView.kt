package com.padcmyanmar.padc9.themoviedbapp.mvp.views

interface MainView: BaseView {
    fun navigatetoMovieListView()
    fun navigateTMovieoDetail(id: Int)
    fun navigatetoMovieSearch()
}