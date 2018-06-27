package co.develoop.mtgcollector.domain.mtg.set

import io.magicthegathering.kotlinsdk.model.set.MtgSet
import io.reactivex.Single

class MtgSetService(
        private val mtgSetRepository: MtgSetRepository
) {

    fun getAllSets(): Single<List<MtgSet>> =
            mtgSetRepository.getAllSets()
}