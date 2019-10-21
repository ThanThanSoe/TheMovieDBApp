package com.padcmyanmar.padc9.themoviedbapp.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc9.themoviedbapp.fragments.BaseFragment
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MovieSearchView

class MovieSearchPresenter: BasePresenter<MovieSearchView>() {

    private lateinit var fragment: BaseFragment

    fun onUiReady(fragment: BaseFragment) {

        this.fragment = fragment

        model.getAllMovies()
            .observe(this.fragment, Observer {
                view.displayMovieList(it)
            })
    }

    fun onTapSearch(title: String) {
        model.search(title)
            .observe(this.fragment, Observer {
                view.displayMovieList(it)
            })
    }

}