package co.develoop.mtgcollector.arch.presenter

import java.lang.reflect.Modifier

class PresenterLifeCycleLinker<T : PresenterView> {

    private lateinit var presenter: Presenter<T>
    private lateinit var presenterView: PresenterView

    fun init(source: Any, presenterView: PresenterView) {
        this.presenterView = presenterView
        linkPresenter(source)
        initPresenter()
    }

    fun initPresenter() {
        presenter.onInit()
    }

    fun resumePresenter() {
        presenter.onResume()
    }

    fun pausePresenter() {
        presenter.onPause()
    }

    fun destroyPresenter() {
        presenter.onDestroy()
    }

    private fun linkPresenter(source: Any) {
        val fields = source.javaClass.declaredFields

        fields.forEach { field ->
            if (field.isAnnotationPresent(IsPresenter::class.java) && !Modifier.isPrivate(field.modifiers)) {
                presenter = field.get(source) as Presenter<T>
            }
        }
    }
}