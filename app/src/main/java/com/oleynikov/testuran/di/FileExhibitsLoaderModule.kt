package com.oleynikov.testuran.di

import android.util.Log
import com.google.gson.GsonBuilder
import com.oleynikov.testuran.network.RetrofitService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class FileExhibitsLoaderModule {

    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/u-android/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor { message -> Log.i("REQUEST","Network=$message") }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor (interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }



}