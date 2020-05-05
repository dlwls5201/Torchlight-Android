package com.mashup.torchlight

import android.app.Application
import com.mashup.data.di.mockRepositoryModule
import com.mashup.data.di.networkModule
import com.mashup.domain.di.usecaseModule
import com.mashup.torchlight.di.appModule
import com.mashup.torchlight.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import timber.log.Timber

class TorchlightApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupKoin() {
        startKoin {
            logger(
                if (BuildConfig.DEBUG) {
                    AndroidLogger()
                } else {
                    EmptyLogger()
                }
            )

            androidContext(this@TorchlightApplication)

            modules(
                listOf(
                    appModule,
                    networkModule,
                    //repositoryModule,
                    mockRepositoryModule,
                    usecaseModule,
                    viewModelModule
                )
            )
        }
    }
}