package travelamn.com.tripslibrary.ui.main

import androidx.fragment.app.Fragment
import travelamn.com.tripslibrary.R
import travelamn.com.tripslibrary.ui.albums.AlbumsFragment
import travelamn.com.tripslibrary.ui.documents.DocumentsFragment
import travelamn.com.tripslibrary.ui.tripslist.TripsListFragment

/**
 * Created by Ilnar on 14,Jan,2020
 */
object SectionsFactory {

    val sectionNames =
        listOf(R.string.nav_trips_title, R.string.nav_gallery_title, R.string.nav_documents_title)

    fun createSection(index: Int): Fragment {
        return when (index) {
            0 -> TripsListFragment()
            1 -> AlbumsFragment()
            2 -> DocumentsFragment()
            else -> {
                throw WrongSectionIndexException()
            }
        }
    }

    class WrongSectionIndexException : Exception()

}