package com.example.tikisample

import android.app.Application
import com.example.tikisample.di.databaseModule
import com.example.tikisample.di.networkModule
import com.example.tikisample.di.repositoryModule
import com.example.tikisample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Quang Nguyen on 7/30/20.
 */
class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(
                databaseModule,
                networkModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }
}