package com.example.kmm.Presenters

import com.example.kmm.Entities.ANumber

class NumberPresenter(private val numberView: NumberView) {

    fun display(number: ANumber) {
        numberView.display(NumberViewModel(number.description()))
    }

    fun ANumber.description() : String {
        return "${value}"
    }
}