package com.oleynikov.testuran.ui.activity.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.oleynikov.testuran.R
import com.oleynikov.testuran.ui.adapters.RvAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var vm: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeVM()
    }

    private fun observeVM() {
        vm = ViewModelProviders.of(this,viewModelFactory).get(MainVM::class.java)
        vm.getList().observe(this,  Observer {
            if (!it.isNullOrEmpty())
            rvMain.adapter = RvAdapter(it)}
        )
    }


}
