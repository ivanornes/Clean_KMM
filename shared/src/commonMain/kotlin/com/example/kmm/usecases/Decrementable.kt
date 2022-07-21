package com.example.kmm.usecases

import com.example.kmm.entities.ANumber

interface Decrementable {
    fun decrement() : ANumber
}