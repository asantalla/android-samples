package co.develoop.mtgcollector.domain.mtg.set

import co.develoop.mtgcollector.domain.mtg.set.datasource.MtgSetApiDataSource
import co.develoop.mtgcollector.domain.mtg.set.datasource.MtgSetCacheDataSource
import io.magicthegathering.kotlinsdk.model.set.MtgSet
import io.reactivex.Observable
import io.reactivex.Single

class MtgSetRepository(
        private val mtgSetApiDataSource: MtgSetApiDataSource,
        private val mtgSetCacheDataSource: MtgSetCacheDataSource
) {

    fun getAllSets(): Single<List<MtgSet>> =
            Observable.concat(
                    mtgSetCacheDataSource.getAllSets(),
                    mtgSetApiDataSource.getAllSets().doOnNext { mtgSetCacheDataSource.saveAllSets(it) }
            ).firstOrError()
}