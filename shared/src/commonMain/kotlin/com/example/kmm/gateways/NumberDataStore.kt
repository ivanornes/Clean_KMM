package com.example.kmm.gateways

import com.example.kmm.entities.ANumber

interface NumberDataStore {
    fun getNumber(): ANumber
    fun saveNumber(number: ANumber)
}