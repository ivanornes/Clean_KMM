package com.example.kmm.gateways

import com.example.kmm.entities.ANumber

class InMemoryNumberDataStore: NumberDataStore {
    private var number = ANumber(0)

    override fun getNumber(): ANumber {
        return number
    }

    override fun saveNumber(number: ANumber) {
        this.number = number
    }
}