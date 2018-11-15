package com.oleynikov.testuran.ui.activity.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.oleynikov.testuran.data_classes.Exhibit
import com.oleynikov.testuran.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainVM @Inject constructor(var apiService: RetrofitService) : ViewModel() {

    private var list = MutableLiveData<MutableList<Exhibit.Item>>()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val toastMessage: MutableLiveData<String> = MutableLiveData<String>()


    fun getList(): MutableLiveData<MutableList<Exhibit.Item>> {

        compositeDisposable.add(
            apiService.getList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list.value = it.list as MutableList },
                            { toastMessage.value = it.localizedMessage })
        )

        return list
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}