package travelamn.com.tripslibrary.base

import android.content.Context
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.lang.ref.WeakReference

abstract class BasePresenter<T : IView> : IPresenter<T> {

    private var view: WeakReference<T>? = null

    protected val viewCompositeDisposable = CompositeDisposable()
    protected val dataCompositeDisposable = CompositeDisposable()

    override fun bind(view: T) {
        this.view = WeakReference(view)
    }

    override fun unbind() {
        view?.clear()
        viewCompositeDisposable.clear()
    }

    override fun getView(): T? {
        return view?.get()
    }

    override fun savePresenter(viewId: String) {
        PresentersStorage.savePresenter(viewId, this)
    }

    override fun removePresenter(viewId: String) {
        PresentersStorage.removePresenter(viewId)
    }

    override fun destroyPresenter() {
        dataCompositeDisposable.dispose()
    }

    override fun saveState(bundle: Bundle) {

    }

    override fun restoreState(bundle: Bundle) {

    }

    protected fun <T> addMain(relay: Observable<T>, function: (T) -> Unit) {
        relay.observeOn(AndroidSchedulers.mainThread())
            .subscribe({ function(it) }, ErrorLogger::log)
            .addTo(viewCompositeDisposable)
    }

    fun context(): Context? {
        return getView()?.getContext()
    }

}
