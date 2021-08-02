package com.psvoid.whappens

import android.app.Application
import android.content.Context
import android.telephony.TelephonyManager
import com.psvoid.whappens.data.network.Config
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else CrashReportingTree())
        //        FirebaseApp.initializeApp(this)

        val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        val countryCode = tm.networkCountryIso.uppercase()
        val countryCode = "RU"
        Config.countries.add(countryCode)
        Timber.i("Network country code: $countryCode")
    }
}

private class CrashReportingTree : Timber.Tree() {
    /**
     * Write a log message to its destination. Called for all level-specific methods by default.
     *
     * @param priority Log level. See [Log] for constants.
     * @param tag Explicit or inferred tag. May be `null`.
     * @param message Formatted log message. May be `null`, but then `t` will not be.
     * @param t Accompanying exceptions. May be `null`, but then `message` will not be.
     */
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        //TODO("Not yet implemented")
    }
}