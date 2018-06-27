package co.develoop.mtgcollector.domain.mtg.set.datasource

import io.magicthegathering.kotlinsdk.model.set.MtgSet
import io.reactivex.Observable

interface MtgSetDataSource {

    fun getAllSets(): Observable<List<MtgSet>>
}