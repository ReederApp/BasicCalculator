package com.iamcodder.basiccalculator

interface Calculate {

    fun sum()
    fun minus()
    fun divide()
    fun multiply()
    fun equals(key: CalculateKey): Double

}