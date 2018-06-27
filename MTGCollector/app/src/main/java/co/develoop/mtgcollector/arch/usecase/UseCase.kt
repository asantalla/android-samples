package co.develoop.mtgcollector.arch.usecase

interface UseCase<T> {

    fun bind(): T
}