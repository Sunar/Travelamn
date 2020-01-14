package travelamn.com.tripslibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * Created by Ilnar on 14,Jan,2020
 */
abstract class BaseActivity : AppCompatActivity(), IView {

    companion object {
        private const val VIEW_ID_KEY: String = "view_id_key"
    }

    protected var viewId: String? = null
    private var isRotated: Boolean = false

    abstract fun attachPresenter()

    abstract fun getPresenter(): IPresenter<out IView>?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewId = savedInstanceState?.getString(VIEW_ID_KEY) ?: generateViewId()
        attachPresenter()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (viewId == null) {
            viewId = savedInstanceState.getString(VIEW_ID_KEY)
        }
        getPresenter()?.restoreState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        isRotated = true
        outState.putString(VIEW_ID_KEY, viewId)
        getPresenter()?.saveState(outState)
        getPresenter()?.savePresenter(viewId!!)
    }

    override fun onDestroy() {
        if (!isRotated) {
            getPresenter()?.removePresenter(viewId!!)
            getPresenter()?.destroyPresenter()
        }
        super.onDestroy()
    }

    override fun generateViewId(): String {
        return UUID.randomUUID().toString()
    }

    override fun getContext() = this

}