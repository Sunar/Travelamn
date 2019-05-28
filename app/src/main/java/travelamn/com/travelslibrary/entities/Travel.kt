package travelamn.com.travelslibrary.entities

/**
 * Created by Ilnar on 28,May,2019
 */
data class Travel(var name: String) {

    var start: Long = System.currentTimeMillis()
    var end: Long = System.currentTimeMillis()

}