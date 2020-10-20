package com.iamcodder.basiccalculator

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

    override fun equals(key: CalculateKey): Double {
        when (key) {
            CalculateKey.SUM -> sum()
            CalculateKey.DIVIDE -> divide()
            CalculateKey.MULTIPLY -> multiply()
            CalculateKey.MINUS -> minus()
            else -> throw Throwable("Calculator error")
        }
        return result
    }


}