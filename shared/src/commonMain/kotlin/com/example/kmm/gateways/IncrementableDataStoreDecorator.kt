package com.example.kmm.gateways

import com.example.kmm.entities.ANumber
import com.example.kmm.usecases.Incrementable

class IncrementableDataStoreDecorator(
    private val decoratee: Incrementable,
    private val dataStore: NumberDataStore
): Incrementable {

    override fun increment(): ANumber {
        val result = decoratee.increment()
        dataStore.saveNumber(result)
        return result
    }
}