package com.padcmyanmar.padc9.themoviedbapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.themoviedbapp.R
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO
import com.padcmyanmar.padc9.themoviedbapp.delegates.MovieListDelegate
import com.padcmyanmar.padc9.themoviedbapp.viewholders.MovieViewHolder

class MovieAdapter(private val delegate: MovieListDelegate): BaseAdapter<MovieViewHolder, MovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_view, parent, false)

        return MovieViewHolder(itemView, delegate)
    }
}