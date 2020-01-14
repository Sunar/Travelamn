package travelamn.com.tripslibrary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import travelamn.com.tripslibrary.R
import travelamn.com.tripslibrary.ui.tripslist.TripsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(content.id, TripsListFragment()).commit()
    }



}
