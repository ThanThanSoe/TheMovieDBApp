package com.padcmyanmar.padc9.themoviedbapp.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

data class GetPopularResponse (
    @SerializedName("page")
    val page: Int,

    @SerializedName("total_results")
    val totalResults: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("results")
    val movies: List<MovieVO>
)