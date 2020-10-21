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

    private lateinit var binding: ActivityMainBinding
    private var firstKey = CalculateKey.SUM
    private val calc by lazy { Calculator() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnSum.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        edxListener()
        btnClick()
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

    private fun btnClick() {
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
        binding.btnPercentage.setOnClickListener {
            setButonBdColor(firstKey, CalculateKey.PERCENTAGE)
        }
        binding.btnClear.setOnClickListener {
            setButonBdColor(firstKey, CalculateKey.CLEAR)
            txtClear()
            setButonBdColor(firstKey, CalculateKey.SUM)
        }
        binding.btnCalculate.setOnClickListener {
            setTxt()
        }
    }

    private fun txtClear() {
        binding.numberOne.text?.clear()
        binding.numberTwo.text?.clear()
        binding.txtResult.text = ""
    }

    private fun setTxt() {
        if (!binding.numberOne.text.isNullOrEmpty() && !binding.numberTwo.text.isNullOrEmpty()) {
            var result = calc.result(firstKey).toString()
            val splittedResult = result.split(".")
            if (splittedResult[1].length > 5) {
                result =
                    splittedResult[0] + "." + splittedResult[1][0] + splittedResult[1][1] + splittedResult[1][2] +
                            splittedResult[1][3] + splittedResult[1][4]
            } else if (splittedResult[1].length == 1 && splittedResult[1] == "0") {
                result = splittedResult[0]
            }
            binding.txtResult.text = result
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
            CalculateKey.PERCENTAGE -> binding.btnPercentage.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.teal_200
                )
            )
            CalculateKey.CLEAR -> binding.btnClear.setBackgroundColor(
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
            CalculateKey.PERCENTAGE -> binding.btnPercentage.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
            CalculateKey.CLEAR -> binding.btnClear.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
            else -> throw Throwable("Bd error")
        }
        this.firstKey = secondKey
    }

}