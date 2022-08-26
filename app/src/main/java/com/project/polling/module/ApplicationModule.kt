package com.project.polling.module

import android.app.Application
import org.koin.core.context.GlobalContext

class ApplicationModule : Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            modules(pollingModule)
        }
    }
}