package com.padcmyanmar.padc9.themoviedbapp.network.dataagents

import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieDetailVO
import com.padcmyanmar.padc9.themoviedbapp.data.vos.MovieVO
import com.padcmyanmar.padc9.themoviedbapp.network.MovieApi
import com.padcmyanmar.padc9.themoviedbapp.network.responses.*
import com.padcmyanmar.padc9.themoviedbapp.utils.ACCESS_TOKEN
import com.padcmyanmar.padc9.themoviedbapp.utils.BASE_URL
import com.padcmyanmar.padc9.themoviedbapp.utils.MOVIE_RESPONSE_FAIL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitMovieDataAgentImpl : MovieDataAgent {

    private var movieApi: MovieApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    override fun getTopRatedMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getTopRatedCalled = movieApi.getTopRatedMovies(ACCESS_TOKEN)

        getTopRatedCalled.enqueue(object : Callback<GetTopRatedResponse> {
            override fun onFailure(call: Call<GetTopRatedResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetTopRatedResponse>,
                response: Response<GetTopRatedResponse>
            ) {
                val topRatedMovieResponse = response.body()

                if (topRatedMovieResponse != null) {
                    if (topRatedMovieResponse.movies != null) {
                        onSuccess(topRatedMovieResponse.movies)
                    } else {
                        onFailure(MOVIE_RESPONSE_FAIL)
                    }
                } else {
                    onFailure("Network Fail")
                }
            }

        })
    }

    override fun getPopularMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        val popularMovieCall = movieApi.getPopularMovieResponse(ACCESS_TOKEN)

        popularMovieCall.enqueue(object : Callback<GetPopularResponse> {
            override fun onFailure(call: Call<GetPopularResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetPopularResponse>,
                response: Response<GetPopularResponse>
            ) {
                val popularMovieResponse = response.body()

                if (popularMovieResponse != null) {
                    if (popularMovieResponse.movies != null) {
                        onSuccess(popularMovieResponse.movies)
                    } else {
                        onFailure(MOVIE_RESPONSE_FAIL)
                    }
                } else {
                    onFailure("Network Fail")
                }
            }

        })
    }

    override fun getNowPlayingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val nowPlayingMovieCall = movieApi.getNowPlayingMoviesResponse(ACCESS_TOKEN)

        nowPlayingMovieCall.enqueue(object : Callback<GetNowPlayingResponse> {
            override fun onFailure(call: Call<GetNowPlayingResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetNowPlayingResponse>,
                response: Response<GetNowPlayingResponse>
            ) {
                val nowPlayingMovieResponse = response.body()

                if (nowPlayingMovieResponse != null) {
                    if (nowPlayingMovieResponse.movies != null) {
                        onSuccess(nowPlayingMovieResponse.movies)
                    } else {
                        onFailure(MOVIE_RESPONSE_FAIL)
                    }
                } else {
                    onFailure("Network Fail")
                }
            }

        })
    }

    override fun getUpComingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val upComingMoviesCall = movieApi.getUpcomingMovieResponse(ACCESS_TOKEN)

        upComingMoviesCall.enqueue(object : Callback<GetUpcomingResponse> {
            override fun onFailure(call: Call<GetUpcomingResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetUpcomingResponse>,
                response: Response<GetUpcomingResponse>
            ) {
                val upcomingMovieResponse = response.body()

                if (upcomingMovieResponse != null) {
                    if (upcomingMovieResponse.movies != null) {
                        onSuccess(upcomingMovieResponse.movies)
                    } else {
                        onFailure(MOVIE_RESPONSE_FAIL)
                    }
                } else {
                    onFailure("Network Fail")
                }
            }

        })
    }

    override fun getMovieDetail(
        id: Int,
        onSuccess: (MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val movieDetailCall = movieApi.getMovieDetail(id, ACCESS_TOKEN)

        movieDetailCall.enqueue(object : Callback<MovieDetailVO> {
            override fun onFailure(call: Call<MovieDetailVO>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<MovieDetailVO>, response: Response<MovieDetailVO>) {
                val movieDetail = response.body()

                if (movieDetail != null) {
                    onSuccess(movieDetail)
                } else {
                    onFailure("Network Fail")
                }
            }

        })
    }

    override fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val similarMoviesCall = movieApi.getSimilarMovie(id, ACCESS_TOKEN)

        similarMoviesCall.enqueue(object : Callback<GetSimilarResponse> {
            override fun onFailure(call: Call<GetSimilarResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetSimilarResponse>,
                response: Response<GetSimilarResponse>
            ) {
                val similarMoviesResponse = response.body()

                if (similarMoviesResponse != null) {
                    if( similarMoviesResponse.movies != null) {
                        onSuccess(similarMoviesResponse.movies)
                    } else {
                        onFailure(MOVIE_RESPONSE_FAIL)
                    }
                } else {
                    onFailure("Network Fail")
                }
            }


        })
    }
}