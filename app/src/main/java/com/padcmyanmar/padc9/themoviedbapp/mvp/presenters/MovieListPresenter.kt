package com.padcmyanmar.padc9.themoviedbapp.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc9.themoviedbapp.fragments.BaseFragment
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MovieListView

class MovieListPresenter: BasePresenter<MovieListView>(){

    fun onUiReady(fragment: BaseFragment) {
        model.getTopRatedMovies()
            .observe(fragment, Observer {
                view.displayTopRatedMovieList(it)
            })

        model.getPopularMovies()
            .observe(fragment, Observer {
                view.displayPopularMovieList(it)
            })

        model.getUpcomingMovies()
            .observe(fragment, Observer {
                view.displayUpcomingMovieList(it)
            })

        model.getNowPlayingMovies()
            .observe(fragment, Observer {
                view.displayNowPlayingMovieList(it)
            })
    }



}