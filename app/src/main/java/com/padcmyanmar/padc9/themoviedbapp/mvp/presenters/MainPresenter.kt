package com.padcmyanmar.padc9.themoviedbapp.mvp.presenters

import com.padcmyanmar.padc9.themoviedbapp.activities.BaseActivity
import com.padcmyanmar.padc9.themoviedbapp.delegates.MovieListDelegate
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MainView

class MainPresenter: BasePresenter<MainView>(), MovieListDelegate {

    fun onUiReady(activity: BaseActivity) {

    }

    override fun onTapMovie(id: Int) {
        view.navigateTMovieoDetail(id)
    }

    fun onTapHome() {
        view.navigatetoMovieListView()
    }

    fun onTabSearch() {
        view.navigatetoMovieSearch()
    }
}