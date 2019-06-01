package travelamn.com.tripslibrary

import android.app.Application
import android.content.Context

/**
 * Created by Ilnar on 01,Jun,2019
 */
class App : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = App.applicationContext()
    }

}