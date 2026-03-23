package com.practicum.films

import android.app.Application
import com.practicum.films.di.dataModule
import com.practicum.films.di.domainModule
import com.practicum.films.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FilmsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FilmsApplication)
            modules(
                dataModule,
                domainModule,
                viewModelModule
            )
        }
    }
}