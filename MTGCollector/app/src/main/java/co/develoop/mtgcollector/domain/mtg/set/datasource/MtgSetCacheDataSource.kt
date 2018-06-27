package co.develoop.mtgcollector.domain.mtg.set.datasource

import co.develoop.mtgcollector.arch.datasource.CacheConfig
import io.magicthegathering.kotlinsdk.model.set.MtgSet
import io.reactivex.Observable
import org.joda.time.DateTime
import org.joda.time.Interval

class MtgSetCacheDataSource(
        private val cacheConfig: CacheConfig
) : MtgSetDataSource {

    private lateinit var cachedDateTime: DateTime
    private lateinit var sets: List<MtgSet>

    fun saveAllSets(sets: List<MtgSet>) {
        this.sets = sets
        cachedDateTime = DateTime.now()
    }

    override fun getAllSets(): Observable<List<MtgSet>> =
            Observable.create { observer ->
                val interval = Interval(cachedDateTime, cachedDateTime.plus(cacheConfig.ttl))

                if (interval.contains(DateTime.now())) {
                    observer.onNext(sets)
                }

                observer.onComplete()
            }
}