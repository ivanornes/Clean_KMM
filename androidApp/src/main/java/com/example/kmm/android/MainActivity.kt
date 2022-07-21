package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kmm.gateways.*
import com.example.kmm.presenters.*
import com.example.kmm.usecases.DecrementNumberInteractor
import com.example.kmm.usecases.Decrementable
import com.example.kmm.usecases.IncrementNumberInteractor
import com.example.kmm.usecases.Incrementable

class MainActivity : AppCompatActivity(), NumberView {

    private var numberDataStore: NumberDataStore = InMemoryNumberDataStore()
    private val numberPresenter = NumberPresenter(this)
    private val incrementNumberInteractor: Incrementable =
        IncrementablePresentationDecorator(
        IncrementableDataStoreDecorator(
        IncrementNumberInteractor(numberDataStore), numberDataStore),
            numberPresenter)

    private val decrementNumberInteractor: Decrementable =
        DecrementablePresentationDecorator(
        DecrementableDataStoreDecorator(
        DecrementNumberInteractor(numberDataStore), numberDataStore),
            numberPresenter)

    private lateinit var tv: TextView
    private lateinit var decrementButton: Button
    private lateinit var incrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.text_view)
        decrementButton = findViewById(R.id.decrement_button)
        incrementButton =  findViewById(R.id.increment_button)

        decrementButton.setOnClickListener {
            decrementNumberInteractor.decrement()
        }
        incrementButton.setOnClickListener {
            incrementNumberInteractor.increment()
        }
    }

    override fun display(viewModel: NumberViewModel) {
        tv.text = viewModel.number
    }
}
