package travelamn.com.tripslibrary.entities

/**
 * Created by Ilnar on 28,May,2019
 */
data class Trip(var name: String) {

    var start: Long = System.currentTimeMillis()
    var end: Long = System.currentTimeMillis()

}