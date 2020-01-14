package travelamn.com.tripslibrary.base

import android.content.Context

/**
 * Created by arsenii on 18.12.17.
 */
interface IView {

    fun generateViewId(): String

    fun getContext(): Context

}