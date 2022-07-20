package com.example.kmm.UseCases

import com.example.kmm.Entities.ANumber

class IncrementNumberInteractor {
    fun increment(number: ANumber) : ANumber {
        return ANumber(number.value + 1)
    }
}