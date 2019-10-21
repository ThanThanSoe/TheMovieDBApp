package com.padcmyanmar.padc9.themoviedbapp.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.padcmyanmar.padc9.themoviedbapp.R
import com.padcmyanmar.padc9.themoviedbapp.fragments.MovieDetailFragment
import com.padcmyanmar.padc9.themoviedbapp.fragments.MovieListFragment
import com.padcmyanmar.padc9.themoviedbapp.fragments.MovieSearchFragment
import com.padcmyanmar.padc9.themoviedbapp.mvp.presenters.MainPresenter
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.MainView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {


    private lateinit var mainPresenter: MainPresenter

    private val movieListFragment = MovieListFragment()
    private val movieDetailFragment = MovieDetailFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mainPresenter.initPresenter(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, movieListFragment)
            .commit()

        babHome.setOnClickListener {
            mainPresenter.onTapHome()
        }

        babSearch.setOnClickListener {
            mainPresenter.onTabSearch()
        }

        mainPresenter.onUiReady(this)
    }

    fun getPresenter(): MainPresenter {
        return mainPresenter
    }

    override fun navigatetoMovieListView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, movieListFragment)
            .commit()
    }

    override fun navigateTMovieoDetail(id: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, MovieDetailFragment.createInstance(id))
            .commit()

    }

    override fun navigatetoMovieSearch() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, MovieSearchFragment.createInstance())
            .commit()
    }

}
