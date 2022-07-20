package com.example.kmm.UseCases

import com.example.kmm.Entities.ANumber

class DecrementNumberInteractor {
    fun decrement(number: ANumber) : ANumber {
        return ANumber(number.value - 1)
    }
}