package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kmm.Entities.ANumber
import com.example.kmm.Presenters.NumberPresenter
import com.example.kmm.Presenters.NumberView
import com.example.kmm.Presenters.NumberViewModel
import com.example.kmm.UseCases.DecrementNumberInteractor
import com.example.kmm.UseCases.IncrementNumberInteractor

class MainActivity : AppCompatActivity(), NumberView {

    private var number = ANumber(0)
    private val numberPresenter = NumberPresenter(this)
    private val incrementNumberInteractor = IncrementNumberInteractor()
    private val decrementNumberInteractor = DecrementNumberInteractor()

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
            number = decrementNumberInteractor.decrement(number)
            numberPresenter.display(number)
        }
        incrementButton.setOnClickListener {
            number = incrementNumberInteractor.increment(number)
            numberPresenter.display(number)
        }
    }

    override fun display(viewModel: NumberViewModel) {
        tv.text = viewModel.number
    }
}
