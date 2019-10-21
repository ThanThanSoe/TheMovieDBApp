package com.padcmyanmar.padc9.themoviedbapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.padcmyanmar.padc9.themoviedbapp.R
import com.padcmyanmar.padc9.themoviedbapp.activities.MainActivity
import com.padcmyanmar.padc9.themoviedbapp.adapters.MovieAdapter
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieDetailVO
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO
import com.padcmyanmar.padc9.themoviedbapp.mvp.presenters.MainPresenter
import com.padcmyanmar.padc9.themoviedbapp.mvp.presenters.MovieDetailPresenter
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MovieDetailView
import com.padcmyanmar.padc9.themoviedbapp.utils.IMAGE_BASE_URL_W300
import com.padcmyanmar.padc9.themoviedbapp.utils.loadUrl
import kotlinx.android.synthetic.main.detail_fragment.view.*

class MovieDetailFragment: BaseFragment(), MovieDetailView {

    private lateinit var parentActivity: MainActivity
    private lateinit var mainPresenter: MainPresenter

    private lateinit var movieDetailPresenter: MovieDetailPresenter

    private var movieDetail: MovieDetailVO? = null
    private lateinit var movieAdapter: MovieAdapter

    companion object {

        private const val PARAM_MOVIE_ID = "MOVIE_ID"

        fun createInstance(id: Int): Fragment {

            val bundle = Bundle()
            bundle.putInt(PARAM_MOVIE_ID, id)

            val fragment = MovieDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter(mainPresenter)

        movieDetailPresenter = ViewModelProviders.of(this).get(MovieDetailPresenter::class.java)
        movieDetailPresenter.initPresenter(this)

        val id = this.arguments!!.getInt(PARAM_MOVIE_ID, 0)


        id?.let {
            movieDetailPresenter.onUiReady(this, id)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = context as MainActivity
        mainPresenter = parentActivity.getPresenter()
    }

    override fun displayMovieDetail(movieDetail: MovieDetailVO) {
        view!!.ivMovieImage.loadUrl(IMAGE_BASE_URL_W300 + movieDetail.posterPath)
    }

    override fun displaySimilarMovies(movies: List<MovieVO>) {
        movieAdapter.setNewData(movies.toMutableList())
    }

    override fun errorDisplayDetail(errorMessage: String) {

    }


}