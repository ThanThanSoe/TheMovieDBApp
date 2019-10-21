package com.padcmyanmar.padc9.themoviedbapp.workers

import android.content.Context
import androidx.work.WorkerParameters
import com.padcmyanmar.padc9.themoviedbapp.network.dataagents.RetrofitMovieDataAgentImpl

class GetNowPlayingWorker(context: Context, workerParameters: WorkerParameters) :
    BaseWorker(context, workerParameters) {

    override fun doWork(): Result {
        var result: Result = Result.failure()

        RetrofitMovieDataAgentImpl.getNowPlayingMovies(
            {
                val movies = it.map { movie ->
                    movie.nowPlaying = true
                    movie
                }
                database.movieDao().saveAll(movies)
                result = Result.success()
            }, {
                result = Result.failure()
            })

        return result
    }
}