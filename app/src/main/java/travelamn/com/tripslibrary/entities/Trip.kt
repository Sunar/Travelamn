package travelamn.com.tripslibrary.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Ilnar on 28,May,2019
 */
@Entity
data class Trip(var name: String) {

    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var start: Long = System.currentTimeMillis()
    var end: Long = System.currentTimeMillis()

}