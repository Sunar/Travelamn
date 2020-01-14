package travelamn.com.tripslibrary.ui.main

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import travelamn.com.tripslibrary.base.BasePresenter

/**
 * Created by Ilnar on 14,Jan,2020
 */
class MainPresenter : BasePresenter<MainView>() {

    private var shownSection = -1
    private val sectionRelay = BehaviorRelay.createDefault(0)

    override fun bind(view: MainView) {
        super.bind(view)
        subscribeSection()
    }

    private fun subscribeSection() {
        sectionRelay.observeOn(AndroidSchedulers.mainThread())
            .filter { it != shownSection }
            .subscribe {
                getView()?.showSection(it)
            }.addTo(viewCompositeDisposable)
    }

    fun sectionShown(index: Int) {
        shownSection = index
    }

    fun sectionSelected(position: Int) {
        sectionRelay.accept(position)
    }

}