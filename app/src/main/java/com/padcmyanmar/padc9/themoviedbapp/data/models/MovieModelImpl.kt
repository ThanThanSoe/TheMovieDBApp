package com.padcmyanmar.padc9.themoviedbapp.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieDetailVO
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

object MovieModelImpl: BaseModel(), MovieModel {

    override fun getAllMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDatabase.movieDao().all())
    }

    override fun getTopRatedMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDatabase.movieDao().topRated())
    }

    override fun getPopularMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDatabase.movieDao().popular())
    }

    override fun getUpcomingMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDatabase.movieDao().upcoming())
    }

    override fun getNowPlayingMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDatabase.movieDao().nowPlayng())
    }

    override fun getMovieDetail(id: Int, onSuccess: (MovieDetailVO) -> Unit, onFailure: (String) -> Unit) {
        movieDataAgent.getMovieDetail(id, {
            onSuccess(it)
        }, {
            onFailure(it)
        })
    }

    override fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        movieDataAgent.getSimilarMovies(id, {
            onSuccess(it)
        }, {
            onFailure(it)
        })
    }

    override fun search(title: String): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDatabase.movieDao().search(title))
    }

}