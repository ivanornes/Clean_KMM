package com.example.kmm.entities

data class ANumber(val value: Int) {
    fun increment() : ANumber {
        return ANumber(value + 1)
    }

    fun decrement() : ANumber {
        return ANumber(value - 1)
    }
}