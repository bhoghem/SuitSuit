package com.bhoghem.suitsuit

enum class PlayerShape(val shape: Int) {
    IDLE(-1), // 0
    ROCK(0), // 1
    PAPER(1), // 2
    SCISSOR(2); // 3
    companion object{
        fun fromInt(shape: Int): PlayerShape {
            val values = PlayerShape.values()
            val result = values.find {
                val isSame = it.shape == shape
                return@find isSame
            }
            return result ?: IDLE
        }
    }
}