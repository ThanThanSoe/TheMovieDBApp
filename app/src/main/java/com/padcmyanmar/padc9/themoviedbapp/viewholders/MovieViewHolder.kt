package com.padcmyanmar.padc9.themoviedbapp.viewholders

import android.view.View
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO
import com.padcmyanmar.padc9.themoviedbapp.delegates.MovieListDelegate
import com.padcmyanmar.padc9.themoviedbapp.utils.IMAGE_BASE_URL_W300
import com.padcmyanmar.padc9.themoviedbapp.utils.loadUrl
import kotlinx.android.synthetic.main.movie_view.view.*

class MovieViewHolder(itemView: View, private val delegate: MovieListDelegate): BaseViewHolder<MovieVO>(itemView) {

    init {
        itemView.setOnClickListener {
            data?.id?.let {id ->
                delegate.onTapMovie(id)
            }
        }
    }

    override fun bindData(movie: MovieVO) {
        itemView.ivMovieImage.loadUrl(IMAGE_BASE_URL_W300 + movie.posterImage)
    }

}