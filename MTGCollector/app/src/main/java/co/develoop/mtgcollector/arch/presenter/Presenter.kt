package co.develoop.mtgcollector.arch.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class Presenter<V : PresenterView> {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var view: V? = null

    protected fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun onDestroy() {
        view = null
        compositeDisposable.clear()
    }

    abstract fun onInit()
    abstract fun onResume()
    abstract fun onPause()
}