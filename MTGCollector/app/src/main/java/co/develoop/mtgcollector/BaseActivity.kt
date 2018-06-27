package co.develoop.mtgcollector

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.develoop.mtgcollector.arch.presenter.PresenterLifeCycleLinker
import co.develoop.mtgcollector.arch.presenter.PresenterView

abstract class BaseActivity : AppCompatActivity(), PresenterView {

    private val presenterLifeCycleLinker: PresenterLifeCycleLinker<PresenterView> = PresenterLifeCycleLinker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Injection
        presenterLifeCycleLinker.init(
                source = this,
                presenterView = this
        )
    }

    override fun onResume() {
        super.onResume()
        presenterLifeCycleLinker.resumePresenter()
    }

    override fun onPause() {
        super.onPause()
        presenterLifeCycleLinker.pausePresenter()
    }

    override fun onDestroy() {
        presenterLifeCycleLinker.destroyPresenter()
        super.onDestroy()
    }
}