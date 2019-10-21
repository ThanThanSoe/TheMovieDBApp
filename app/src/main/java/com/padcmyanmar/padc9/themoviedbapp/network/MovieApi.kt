package com.padcmyanmar.padc9.themoviedbapp.network

import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieDetailVO
import com.padcmyanmar.padc9.themoviedbapp.network.responses.*
import com.padcmyanmar.padc9.themoviedbapp.utils.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_TOP_RATED)
    fun getTopRatedMovies(@Query(PARAM_API_KEY) apiKey: String): Call<GetTopRatedResponse>

    @GET(GET_NOW_PLAYING)
    fun getNowPlayingMoviesResponse(@Query(PARAM_API_KEY) apiKey: String): Call<GetNowPlayingResponse>

    @GET(GET_POPULAR)
    fun getPopularMovieResponse(@Query(PARAM_API_KEY) apiKey: String): Call<GetPopularResponse>

    @GET(GET_UPCOMING)
    fun getUpcomingMovieResponse(@Query(PARAM_API_KEY) apiKey: String): Call<GetUpcomingResponse>

    @GET(GET_MOVIE_DETAIL)
    fun getMovieDetail(@Path("id") id: Int, @Query(PARAM_API_KEY) apiKey: String): Call<MovieDetailVO>

    @GET(GET_SIMILAR_MOVIES)
    fun getSimilarMovie(@Path("id") id: Int, @Query(PARAM_API_KEY) apiKey: String): Call<GetSimilarResponse>
}