package com.iamcodder.basiccalculator.interfaces

import com.iamcodder.basiccalculator.enums.CalculateKey

interface Calculate {

    fun sum()
    fun minus()
    fun divide()
    fun multiply()
    fun result(key: CalculateKey): Double

}