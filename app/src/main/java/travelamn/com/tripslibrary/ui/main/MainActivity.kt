package travelamn.com.tripslibrary.ui.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import travelamn.com.tripslibrary.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        if (savedInstanceState == null) {
            showContent(viewModel.initialSectionIndex)
        }
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            SectionsController.sectionNames.map { getString(it) })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSections.adapter = adapter
        spinnerSections.setSelection(viewModel.sectionIndex)
        spinnerSections.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                showContent(position)
            }
        }
    }

    private fun showContent(index: Int) {
        if (viewModel.sectionIndex == index) {
            return
        }
        viewModel.sectionIndex = index
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, SectionsController.createSection(index)).commit()
    }

}
