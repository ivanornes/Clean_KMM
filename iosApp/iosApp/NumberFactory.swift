//
//  NumberFactory.swift
//  iosApp
//
//  Created by Ivan Ornes on 20/7/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class NumberFactory {
    func makeNumberView() -> NumbersView {
        let viewModel = NumbersViewModel()
        let incrementNumberInteractor = IncrementNumberInteractor()
        let decrementNumberInteractor = DecrementNumberInteractor()
        let numberPresenter = NumberPresenter(numberView: viewModel)
        var number = ANumber(value: 0)

        let view = NumbersView(contentViewModel: viewModel)
        viewModel.increment = {
            number = incrementNumberInteractor.increment(number: number)
            numberPresenter.display(number: number)
        }
        viewModel.decrement = {
            number = decrementNumberInteractor.decrement(number: number)
            numberPresenter.display(number: number)
        }
        return view
    }
}
