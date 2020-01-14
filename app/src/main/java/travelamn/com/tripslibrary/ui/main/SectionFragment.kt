package travelamn.com.tripslibrary.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import travelamn.com.tripslibrary.App
import travelamn.com.tripslibrary.R

/**
 * Created by Ilnar on 14,Jan,2020
 */
abstract class SectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dummy_fragment_view, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(
            ContextCompat.getColor(
                App.applicationContext(),
                getBackgroundColorResource()
            )
        )
    }

    abstract fun getBackgroundColorResource(): Int

}