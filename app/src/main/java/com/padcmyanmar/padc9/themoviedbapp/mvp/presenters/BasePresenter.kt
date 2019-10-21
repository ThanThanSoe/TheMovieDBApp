package com.padcmyanmar.padc9.themoviedbapp.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padc9.themoviedbapp.data.models.MovieModelImpl
import com.padcmyanmar.padc9.themoviedbapp.mvp.views.BaseView

abstract class BasePresenter<T: BaseView>: ViewModel()  {

    protected val model = MovieModelImpl

    protected lateinit var view: T

    fun initPresenter(view: T) {
        this.view = view
    }
}