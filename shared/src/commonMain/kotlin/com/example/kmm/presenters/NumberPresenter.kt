package com.example.kmm.presenters

import com.example.kmm.entities.ANumber

class NumberPresenter(private val numberView: NumberView) {

    fun display(number: ANumber) {
        numberView.display(NumberViewModel(number.description()))
    }

    fun ANumber.description() : String {
        return "${value}"
    }
}