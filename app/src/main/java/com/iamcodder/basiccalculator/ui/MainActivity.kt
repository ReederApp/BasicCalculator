package com.iamcodder.basiccalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.iamcodder.basiccalculator.R
import com.iamcodder.basiccalculator.databinding.ActivityMainBinding
import com.iamcodder.basiccalculator.enums.CalculateKey
import com.iamcodder.basiccalculator.model.Calculator

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private var firstKey = CalculateKey.SUM
    private var secondKey = firstKey
    private val calc by lazy { Calculator() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnSum.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.teal_200
            )
        )
        edxListener()
        roundBtnClick()
        resultButton()
    }

    private fun edxListener() {
        binding.numberOne.addTextChangedListener { it ->
            it?.toString()?.let {
                if (it.isNotEmpty() && it.isNotBlank()) calc.numberOne = it.toDouble()
                else calc.numberOne = 0.0
            }
        }
        binding.numberTwo.addTextChangedListener { it ->
            it?.toString()?.let {
                if (it.isNotEmpty() && it.isNotBlank()) calc.numberTwo = it.toDouble()
                else calc.numberTwo = 0.0
            }
        }
    }

    private fun roundBtnClick() {
        binding.btnSum.setOnClickListener {
            setButonBdColor(firstKey, CalculateKey.SUM)
        }
        binding.btnDivide.setOnClickListener {
            setButonBdColor(firstKey, CalculateKey.DIVIDE)

        }
        binding.btnMinus.setOnClickListener {
            setButonBdColor(firstKey, CalculateKey.MINUS)
        }
        binding.btnMultiply.setOnClickListener {
            setButonBdColor(firstKey, CalculateKey.MULTIPLY)
        }
    }

    private fun setButonBdColor(firstKey: CalculateKey, secondKey: CalculateKey) {
        when (firstKey) {
            CalculateKey.SUM -> binding.btnSum.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.teal_200
                )
            )
            CalculateKey.MINUS -> binding.btnMinus.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.teal_200
                )
            )
            CalculateKey.DIVIDE -> binding.btnDivide.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.teal_200
                )
            )
            CalculateKey.MULTIPLY -> binding.btnMultiply.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.teal_200
                )
            )
            else -> throw Throwable("Bd error")
        }
        when (secondKey) {
            CalculateKey.SUM -> binding.btnSum.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
            CalculateKey.MINUS -> binding.btnMinus.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
            CalculateKey.DIVIDE -> binding.btnDivide.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
            CalculateKey.MULTIPLY -> binding.btnMultiply.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
            else -> throw Throwable("Bd error")
        }
        this.firstKey = secondKey
    }

    private fun resultButton() {
        binding.btnCalculate.setOnClickListener {
            binding.txtResult.text = "${calc.result(firstKey)}"
        }
    }
}