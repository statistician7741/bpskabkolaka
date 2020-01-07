package com.muhshamad.bpskabkolaka


class PokemonSetRepository private constructor () {
    private var setLocalDataStore: PokemonSetDataStore? = null
    private var setRemoteDataStore: PokemonSetDataStore? = null

    fun init(setLocalDataStore: PokemonSetDataStore, setRemoteDataStore: PokemonSetRemoteDataStore) {
        this.setLocalDataStore = setLocalDataStore
        this.setRemoteDataStore = setRemoteDataStore
    }

    suspend fun getSets(): MutableList<PokemonSet>? {
        val cache = setLocalDataStore?.getSets()
        if (cache != null) return cache
        val response = setRemoteDataStore?.getSets()
        setLocalDataStore?.addAll(response)
        return response
    }

    companion object {
        val instance by lazy { PokemonSetRepository() }
    }
}