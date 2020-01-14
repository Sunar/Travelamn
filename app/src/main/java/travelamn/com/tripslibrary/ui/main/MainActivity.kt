package travelamn.com.tripslibrary.ui.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import travelamn.com.tripslibrary.R
import travelamn.com.tripslibrary.base.BaseActivity
import travelamn.com.tripslibrary.base.IPresenter
import travelamn.com.tripslibrary.base.IView
import travelamn.com.tripslibrary.base.PresentersStorage

class MainActivity : BaseActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
            SectionsFactory.sectionNames.map { getString(it) })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSections.adapter = adapter
        spinnerSections.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.sectionSelected(position)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.bind(this)
    }

    override fun showSection(index: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, SectionsFactory.createSection(index)).commit()
        presenter.sectionShown(index)
    }

    override fun attachPresenter() {
        presenter = PresentersStorage.getPresenter(viewId!!) as? MainPresenter ?: MainPresenter()
    }

    override fun getPresenter(): IPresenter<out IView>? = presenter

}
