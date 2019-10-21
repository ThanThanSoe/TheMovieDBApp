package com.padcmyanmar.padc9.themoviedbapp.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc9.themoviedbapp.fragments.BaseFragment
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MovieDetailView
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MovieListView

class MovieDetailPresenter: BasePresenter<MovieDetailView>() {

    fun onUiReady(fragment: BaseFragment, id: Int) {
        model.getMovieDetail(id, {
            view.displayMovieDetail(it)
        }, {
            view.errorDisplayDetail(it)
        })

        model.getSimilarMovies(id, {
            view.displaySimilarMovies(it)
        }, {
            view.errorDisplayDetail(it)
        })
    }
}