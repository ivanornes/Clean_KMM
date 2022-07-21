package com.example.kmm.presenters

import com.example.kmm.entities.ANumber
import com.example.kmm.usecases.Decrementable

class DecrementablePresentationDecorator(
    private val decoratee: Decrementable,
    private val presenter: NumberPresenter
): Decrementable {
    override fun decrement(): ANumber {
        val result = decoratee.decrement()
        presenter.display(result)
        return result
    }
}