package co.develoop.mtgcollector.screen.main

import android.os.Bundle
import co.develoop.mtgcollector.BaseActivity
import co.develoop.mtgcollector.R
import co.develoop.mtgcollector.arch.presenter.IsPresenter
import co.develoop.mtgcollector.arch.presenter.Presenter
import co.develoop.mtgcollector.arch.presenter.PresenterView

class MainActivity : BaseActivity(), MainPresenterView {

    @JvmField
    @IsPresenter
    val presenter: Presenter<out PresenterView> = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}