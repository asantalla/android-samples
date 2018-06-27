package co.develoop.mtgcollector.domain.mtg.set.datasource

import io.magicthegathering.kotlinsdk.api.MtgSetApiClient
import io.magicthegathering.kotlinsdk.model.set.MtgSet
import io.reactivex.Observable

class MtgSetApiDataSource : MtgSetDataSource {

    override fun getAllSets(): Observable<List<MtgSet>> =
            MtgSetApiClient.getAllSetsObservable()
}