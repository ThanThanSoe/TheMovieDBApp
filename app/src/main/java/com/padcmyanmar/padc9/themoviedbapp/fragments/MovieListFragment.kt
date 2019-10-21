package com.padcmyanmar.padc9.themoviedbapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padc9.themoviedbapp.R
import com.padcmyanmar.padc9.themoviedbapp.activities.MainActivity
import com.padcmyanmar.padc9.themoviedbapp.adapters.MovieAdapter
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO
import com.padcmyanmar.padc9.themoviedbapp.mvp.presenters.MainPresenter
import com.padcmyanmar.padc9.themoviedbapp.mvp.presenters.MovieListPresenter
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MovieListView
import kotlinx.android.synthetic.main.movie_list_fragment.view.*

class MovieListFragment: BaseFragment(), MovieListView {

    private lateinit var parentActivity: MainActivity

    lateinit var topRateMoviesAdapter: MovieAdapter
    lateinit var popularMoviesAdapter: MovieAdapter
    lateinit var upcomingMoviesAdapter: MovieAdapter
    lateinit var nowPlayingMoviesAdapter: MovieAdapter

    private lateinit var movieListPresenter: MovieListPresenter
    private lateinit var mainPresenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        movieListPresenter = ViewModelProviders.of(this).get(MovieListPresenter::class.java)
        movieListPresenter.initPresenter(this)

        topRateMoviesAdapter = MovieAdapter(mainPresenter)
        popularMoviesAdapter = MovieAdapter(mainPresenter)
        upcomingMoviesAdapter = MovieAdapter(mainPresenter)
        nowPlayingMoviesAdapter = MovieAdapter(mainPresenter)

        view.rvTopRatedMovie.apply {
            this.layoutManager = LinearLayoutManager(this@MovieListFragment.context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = topRateMoviesAdapter
        }

        view.rvPopularMovies.apply {
            this.layoutManager = LinearLayoutManager(this@MovieListFragment.context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = popularMoviesAdapter
        }

        view.rvUpComingMovies.apply {
            this.layoutManager = LinearLayoutManager(this@MovieListFragment.context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = upcomingMoviesAdapter
        }

        view.rvNowPlayingMovies.apply {
            this.layoutManager = LinearLayoutManager(this@MovieListFragment.context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = nowPlayingMoviesAdapter
        }

        movieListPresenter.onUiReady(this)
    }

    override fun displayTopRatedMovieList(movies: List<MovieVO>) {
        topRateMoviesAdapter.setNewData(movies.toMutableList())
    }

    override fun displayPopularMovieList(movies: List<MovieVO>) {
        popularMoviesAdapter.setNewData(movies.toMutableList())
    }

    override fun displayUpcomingMovieList(movies: List<MovieVO>) {
        upcomingMoviesAdapter.setNewData(movies.toMutableList())
    }

    override fun displayNowPlayingMovieList(movies: List<MovieVO>) {
        nowPlayingMoviesAdapter.setNewData(movies.toMutableList())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = context as MainActivity
        mainPresenter = parentActivity.getPresenter()
    }


    override fun displayErrorMessage(errorMessage: String) {
    }

}