package com.example.kmm.presenters

import com.example.kmm.entities.ANumber
import com.example.kmm.usecases.Incrementable

class IncrementablePresentationDecorator(
    private val decoratee: Incrementable,
    private val presenter: NumberPresenter
): Incrementable {
    override fun increment(): ANumber {
        val result = decoratee.increment()
        presenter.display(result)
        return result
    }
}