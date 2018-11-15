package com.oleynikov.testuran.di

import android.app.Application
import com.oleynikov.testuran.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, FileExhibitsLoaderModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<App> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application : Application) : AppComponent.Builder
        fun build() : AppComponent
    }

    override fun inject(app : App)
}