package com.example.githubrepository

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.example.githubrepository.helper.PreferenceHelper
import com.facebook.stetho.Stetho
import io.fabric.sdk.android.Fabric
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var instance: App private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        //for API debugging
        Stetho.initializeWithDefaults(applicationContext)

        //init crash analytics
        val fabric = Fabric.Builder(this).kits(Crashlytics()).debuggable(true).build()
        Fabric.with(fabric)

        //init timber log
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        //init koin DI
        startKoin { androidContext(this@App) }

        //init pref
        PreferenceHelper.init(applicationContext)
    }
}