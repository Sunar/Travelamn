package travelamn.com.tripslibrary.dao

import androidx.room.*
import io.reactivex.Flowable
import travelamn.com.tripslibrary.entities.Trip

/**
 * Created by Ilnar on 01,Jun,2019
 */
@Dao
interface TripDao {

    @Query("SELECT * FROM Trip")
    fun getTrips(): Flowable<List<Trip>>

    @Query("SELECT * FROM Trip WHERE :id == id LIMIT 1")
    fun getTrip(id: String)

    @Insert
    fun insert(trip: Trip)

    @Update
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)

}