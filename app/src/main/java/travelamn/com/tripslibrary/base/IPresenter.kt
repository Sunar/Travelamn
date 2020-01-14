package travelamn.com.tripslibrary.base

import android.os.Bundle

/**
 * Created by arsenii on 18.12.17.
 */
interface IPresenter<T : IView> {

    fun bind(view: T)

    fun unbind()

    fun getView(): T?

    fun savePresenter(viewId: String)

    fun removePresenter(viewId: String)

    fun destroyPresenter()

    fun saveState(bundle: Bundle)

    fun restoreState(bundle: Bundle)

}