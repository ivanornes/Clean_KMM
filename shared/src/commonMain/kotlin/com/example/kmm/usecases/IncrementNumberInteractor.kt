package com.example.kmm.usecases

import com.example.kmm.entities.ANumber
import com.example.kmm.gateways.NumberDataStore

class IncrementNumberInteractor(
    private val numberDataStore: NumberDataStore
): Incrementable {
    override fun increment() : ANumber {
        return numberDataStore.getNumber().increment()
    }
}