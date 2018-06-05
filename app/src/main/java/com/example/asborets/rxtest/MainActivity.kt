package com.example.asborets.rxtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.Screen {

    val presenter:MainContract.Presenter = MainPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onCreate(this)

        button.setOnClickListener{
            presenter.stopEmitting()
        }
    }

    override fun showValue(value: String) {
        value_layout.text = value
    }
}
