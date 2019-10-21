package com.padcmyanmar.padc9.themoviedbapp

import android.app.Application
import androidx.work.*
import com.padcmyanmar.padc9.themoviedbapp.data.models.BaseModel
import com.padcmyanmar.padc9.themoviedbapp.workers.GetNowPlayingWorker
import com.padcmyanmar.padc9.themoviedbapp.workers.GetPopularWorker
import com.padcmyanmar.padc9.themoviedbapp.workers.GetTopRatedWorker
import com.padcmyanmar.padc9.themoviedbapp.workers.GetUpComingWorker
import java.util.concurrent.TimeUnit

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        BaseModel.initDatabase(applicationContext)
        getMoviesOnce()
//        getMovies()
    }

    private fun getMoviesOnce() {
        val getTopRatedMoviesRequest = OneTimeWorkRequest.Builder(GetTopRatedWorker::class.java).build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesRequest)

        val getPopularMoviesRequest = OneTimeWorkRequest.Builder(GetPopularWorker::class.java).build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesRequest)

        val getUpcomingMovieRequest = OneTimeWorkRequest.Builder(GetUpComingWorker::class.java).build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getUpcomingMovieRequest)

        val getNowPlayingMovieRequest = OneTimeWorkRequest.Builder(GetNowPlayingWorker::class.java).build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getNowPlayingMovieRequest)
    }

    private fun getMovies() {
        val constraints = Constraints
            .Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getTopRatedMoviesRequest = PeriodicWorkRequest
            .Builder(GetTopRatedWorker::class.java, 30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesRequest)

        val getPopularMoviesRequest = PeriodicWorkRequest
            .Builder(GetPopularWorker::class.java, 30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesRequest)

        val getUpcomingMoviesRequest = PeriodicWorkRequest
            .Builder(GetUpComingWorker::class.java, 30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getUpcomingMoviesRequest)

        val getNowPlayingMovieRequest = PeriodicWorkRequest
            .Builder(GetNowPlayingWorker::class.java, 30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getNowPlayingMovieRequest)
    }
}