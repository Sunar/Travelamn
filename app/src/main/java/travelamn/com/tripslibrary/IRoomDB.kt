package travelamn.com.tripslibrary

import androidx.room.Database
import androidx.room.RoomDatabase
import travelamn.com.tripslibrary.dao.TripDao
import travelamn.com.tripslibrary.entities.Trip

/**
 * Created by Ilnar on 01,Jun,2019
 */
@Database(version = 1, entities = [Trip::class])
abstract class IRoomDB : RoomDatabase() {

    abstract val tripDao: TripDao

}