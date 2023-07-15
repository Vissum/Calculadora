package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            calculateResult()
        }
    }

    private fun calculateResult() {
        val number1 = editTextNumber1.text.toString().toDouble()
        val number2 = editTextNumber2.text.toString().toDouble()

        val result = when {
            findViewById<RadioButton>(R.id.radioButtonOption1).isChecked -> number1 + number2
            findViewById<RadioButton>(R.id.radioButtonOption2).isChecked -> number1 - number2
            findViewById<RadioButton>(R.id.radioButton).isChecked -> number1 / number2
            findViewById<RadioButton>(R.id.radioButton2).isChecked -> number1 * number2
            else -> 0.0
        }

        val resultText = getString(R.string.result_text, result.toString())
        textViewResult.text = resultText
    }

}
