package com.ineight.currencytest

import android.app.Application
import com.ineight.currencytest.di.PersistenceModules.persistenceModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)

            //modules
            modules(persistenceModules)

        }
    }
}