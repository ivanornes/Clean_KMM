package com.example.kmm.gateways

import com.example.kmm.entities.ANumber
import com.example.kmm.usecases.Decrementable

class DecrementableDataStoreDecorator(
    private val decoratee: Decrementable,
    private val dataStore: NumberDataStore
): Decrementable {

    override fun decrement(): ANumber {
        val result = decoratee.decrement()
        dataStore.saveNumber(result)
        return result
    }
}