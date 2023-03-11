package ru.effectiv.mobile.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.effectiv.mobile.di.appModule
import ru.effectiv.mobile.di.dataModule
import ru.effectiv.mobile.di.domainModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}