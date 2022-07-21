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
        let numberDataStore: NumberDataStore = InMemoryNumberDataStore()
        let viewModel = NumbersViewModel()
        let numberPresenter = NumberPresenter(numberView: viewModel)
        
        let incrementNumberInteractor: Incrementable =
            IncrementablePresentationDecorator(
                decoratee: IncrementableDataStoreDecorator(
                    decoratee: IncrementNumberInteractor(
                        numberDataStore: numberDataStore),
                    dataStore: numberDataStore),
                presenter: numberPresenter)

        let decrementNumberInteractor: Decrementable =
            DecrementablePresentationDecorator(
                decoratee: DecrementableDataStoreDecorator(
                    decoratee: DecrementNumberInteractor(
                        numberDataStore: numberDataStore),
                    dataStore: numberDataStore),
                presenter: numberPresenter)
        
        let view = NumbersView(contentViewModel: viewModel)
        viewModel.increment = {
            incrementNumberInteractor.increment()
        }
        viewModel.decrement = {
            decrementNumberInteractor.decrement()
        }
        return view
    }
}
