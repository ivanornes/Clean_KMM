//
//  NumbersView.swift
//  iosApp
//
//  Created by Ivan Ornes on 20/7/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

public struct NumbersView: View {
    
    @ObservedObject public var contentViewModel:  NumbersViewModel
    
    public init(contentViewModel:  NumbersViewModel) {
        self.contentViewModel = contentViewModel
    }
    
    public var body: some View {
        HStack {
            Button("-") {
                contentViewModel.decrement?()
            }
            Text(contentViewModel.number).padding()
            Button("+") {
                contentViewModel.increment?()
            }
        }
    }
}

struct NumbersView_Previews: PreviewProvider {
    static var previews: some View {
        NumbersView(contentViewModel: .init())
    }
}
