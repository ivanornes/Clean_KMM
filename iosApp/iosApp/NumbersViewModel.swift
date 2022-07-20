//
//  NumbersViewModel.swift
//  iosApp
//
//  Created by Ivan Ornes on 20/7/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

public class NumbersViewModel: ObservableObject {
    @Published var number: String
    
    public var increment: (()->Void)?
    public var decrement: (()->Void)?
    
    public init(number: String = "") {
        self.number = number
    }
}

extension NumbersViewModel: NumberView {
    
    public func display(viewModel: NumberViewModel) {
        self.number = viewModel.number
    }
}
