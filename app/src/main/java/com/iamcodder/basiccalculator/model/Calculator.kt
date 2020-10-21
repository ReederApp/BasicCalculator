package com.iamcodder.basiccalculator.model

import com.iamcodder.basiccalculator.enums.CalculateKey
import com.iamcodder.basiccalculator.interfaces.Calculate

class Calculator : Calculate {

    var numberOne: Double = 0.0
    var numberTwo: Double = 0.0
    private var result: Double = 0.0

    override fun sum() {
        result = numberOne + numberTwo
    }

    override fun minus() {
        result = numberOne - numberTwo
    }

    override fun divide() {
        result = numberOne / numberTwo
    }

    override fun multiply() {
        result = numberOne * numberTwo
    }

    override fun percentage() {
        result = numberOne % numberTwo
    }

    override fun clear() {
        numberOne = 0.0
        numberTwo = 0.0
        result = 0.0
    }

    override fun result(key: CalculateKey): Double {
        when (key) {
            CalculateKey.SUM -> sum()
            CalculateKey.DIVIDE -> divide()
            CalculateKey.MULTIPLY -> multiply()
            CalculateKey.MINUS -> minus()
            CalculateKey.PERCENTAGE -> percentage()
            CalculateKey.CLEAR -> clear()
            else -> throw Throwable("Calculator error")
        }
        return result
    }


}