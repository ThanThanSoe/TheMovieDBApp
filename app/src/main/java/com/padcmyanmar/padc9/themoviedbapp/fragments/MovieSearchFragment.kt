package com.padcmyanmar.padc9.themoviedbapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.padcmyanmar.padc9.themoviedbapp.R
import com.padcmyanmar.padc9.themoviedbapp.activities.MainActivity
import com.padcmyanmar.padc9.themoviedbapp.adapters.MovieAdapter
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO
import com.padcmyanmar.padc9.themoviedbapp.mvp.presenters.MainPresenter
import com.padcmyanmar.padc9.themoviedbapp.mvp.presenters.MovieSearchPresenter
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MovieSearchView

class MovieSearchFragment: BaseFragment(), MovieSearchView {


    private lateinit var parentActivity: MainActivity


    lateinit var movieAdapter: MovieAdapter

    private lateinit var presenter: MovieSearchPresenter
    private lateinit var mainPresenter: MainPresenter

    companion object {
        fun createInstance(): MovieSearchFragment {
            val fragment = MovieSearchFragment()
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter = ViewModelProviders.of(this).get(MovieSearchPresenter::class.java)
        presenter.initPresenter(this)

        movieAdapter = MovieAdapter(mainPresenter)

        presenter.onUiReady(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = context as MainActivity
        mainPresenter = parentActivity.getPresenter()
    }

    override fun displayMovieList(movies: List<MovieVO>) {
        movieAdapter.setNewData(movies.toMutableList())
    }

    override fun diplsayResultNotFound(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}