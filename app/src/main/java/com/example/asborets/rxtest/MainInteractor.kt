package com.example.asborets.rxtest

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainInteractor {
    fun run(presenter:MainPresenter) {
        var observable: Observable<Long> = Observable.range(1, 50)
                .flatMap { s -> Observable.interval(1, TimeUnit.SECONDS)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        val subscriber = observable.subscribe{
            presenter.updateUI(it.toString())
        }

        presenter.registerDisposable(subscriber)
    }
}