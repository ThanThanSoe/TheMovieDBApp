package com.padcmyanmar.padc9.themoviedbapp.workers

import android.content.Context
import androidx.work.WorkerParameters
import com.padcmyanmar.padc9.themoviedbapp.network.dataagents.RetrofitMovieDataAgentImpl

class GetPopularWorker(context: Context, workerParameters: WorkerParameters) :
    BaseWorker(context, workerParameters) {

    override fun doWork(): Result {
        var result: Result = Result.failure()

        RetrofitMovieDataAgentImpl.getPopularMovies(
            {
                database.movieDao().saveAll(it)
                result = Result.success()
            }, {
                result = Result.failure()
            })

        return result
    }
}