package com.mindyhsu.tdd

fun pickBitrate(availableBitrates: List<Int>, networkSpeed: Int): Int? =
    availableBitrates.filter { it <= networkSpeed }.maxOrNull()
        ?: availableBitrates.minOrNull()