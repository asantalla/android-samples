package co.develoop.mtgcollector.usecase.mtg.set

import co.develoop.mtgcollector.domain.mtg.set.MtgSetService
import co.develoop.mtgcollector.arch.usecase.UseCase
import io.magicthegathering.kotlinsdk.model.set.MtgSet
import io.reactivex.Single

class LoadMtgSetsUseCase(
        private val mtgSetService: MtgSetService
) : UseCase<Single<List<MtgSet>>> {

    override fun bind(): Single<List<MtgSet>> =
            mtgSetService.getAllSets()
}