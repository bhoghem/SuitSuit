package com.bhoghem.suitsuit

enum class PlayerShape(val shape: Int) {
    IDDLE(-1),
    ROCK(0),
    PAPPER(1),
    SCISSOR(2);
    companion object{
        fun fromInt(shape: Int)= values().first()
    }
}