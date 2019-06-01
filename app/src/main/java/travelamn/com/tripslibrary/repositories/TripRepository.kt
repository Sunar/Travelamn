package travelamn.com.tripslibrary.repositories

import travelamn.com.tripslibrary.Database

/**
 * Created by Ilnar on 01,Jun,2019
 */
object TripRepository {

    private val tripDao = Database.roomDatabase.tripDao

    fun getTrips() = tripDao.getTrips()

    fun getTrip(id: String) = tripDao.getTrip(id)

}