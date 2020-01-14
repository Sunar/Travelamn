package travelamn.com.tripslibrary.base

object PresentersStorage {

    private val presenters = HashMap<String, IPresenter<*>>()

    fun getPresenter(viewId: String): IPresenter<*>? {
        return presenters.get(viewId)
    }

    fun savePresenter(viewId: String, presenter: IPresenter<*>) {
        presenters.put(viewId, presenter)
    }

    fun removePresenter(viewId: String) {
        presenters.remove(viewId)
    }

}