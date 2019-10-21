package com.padcmyanmar.padc9.themoviedbapp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.padcmyanmar.padc9.themoviedbapp.persistence.MovieDatabase

abstract class BaseWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    protected val database = MovieDatabase.getInstance(context)
}