package travelamn.com.tripslibrary

import androidx.room.Room

/**
 * Created by Ilnar on 01,Jun,2019
 */
object Database {

    val roomDatabase: IRoomDB by lazy {
        val builder = Room.databaseBuilder(
            App.applicationContext(), IRoomDB::class.java,
            "rubetekHouses.db"
        )
        if (!BuildConfig.DEBUG) {
            builder.fallbackToDestructiveMigration()
        }
        return@lazy builder.build()
    }

}