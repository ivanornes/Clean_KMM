package com.example.kmm.usecases

import com.example.kmm.entities.ANumber
import com.example.kmm.gateways.NumberDataStore

class DecrementNumberInteractor(
    private val numberDataStore: NumberDataStore
    ): Decrementable {
    override fun decrement() : ANumber {
        return numberDataStore.getNumber().decrement()
    }
}