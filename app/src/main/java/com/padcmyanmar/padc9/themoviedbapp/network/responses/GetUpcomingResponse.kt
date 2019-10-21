package com.padcmyanmar.padc9.themoviedbapp.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO

data class GetUpcomingResponse (
    @SerializedName("results")
    val movies: List<MovieVO>
)