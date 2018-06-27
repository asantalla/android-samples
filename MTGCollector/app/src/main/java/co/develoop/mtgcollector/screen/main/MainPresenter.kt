package co.develoop.mtgcollector.screen.main

import android.util.Log
import co.develoop.mtgcollector.arch.presenter.Presenter

class MainPresenter : Presenter<MainPresenterView>() {

    override fun onInit() {
        Log.d("POLLO", "Init")
    }

    override fun onResume() {
        Log.d("POLLO", "Resume")
    }

    override fun onPause() {
        Log.d("POLLO", "Pause")
    }
}