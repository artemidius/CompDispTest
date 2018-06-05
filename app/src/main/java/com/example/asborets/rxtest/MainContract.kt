package com.example.asborets.rxtest

interface MainContract {
    interface Presenter {
        fun onCreate(activity: MainActivity)
        fun stopEmitting()
    }

    interface Screen {
        fun showValue(value:String)
    }
}