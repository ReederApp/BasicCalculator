package com.iamcodder.basiccalculator.enums

enum class CalculateKey {
    SUM {
        override fun key() = 0
    },
    MINUS {
        override fun key() = 1
    },
    DIVIDE {
        override fun key() = 2
    },
    MULTIPLY {
        override fun key() = 3
    },
    EQUALS {
        override fun key() = 4
    };

    abstract fun key(): Int
}

