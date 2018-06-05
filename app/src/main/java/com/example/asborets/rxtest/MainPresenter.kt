package com.example.asborets.rxtest

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MainPresenter:MainContract.Presenter {

    lateinit var screen:MainContract.Screen

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    lateinit var mainActivity: MainActivity

    override fun onCreate(activity: MainActivity) {
        mainActivity = activity
        screen = activity

        MainInteractor().run(this)
    }

    fun registerDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun stopEmitting() {
        compositeDisposable.clear()
    }

    fun updateUI(data:String) {
        screen.showValue(data)
    }

}