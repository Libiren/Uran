package com.oleynikov.testuran.network

import com.oleynikov.testuran.data_classes.Exhibit
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("41ade05b6ae1133e7e86e9dfd55f1794/raw/bab1c383b0384d1a4c889b399ad7b13ae05634fa/ios%20challenge%20json")
    fun getList(): Single<Exhibit>
}