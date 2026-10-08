package com.mindyhsu.tdd

fun formatDuration(totalSeconds: Int): String {
    if (totalSeconds < 0) throw IllegalArgumentException()

    val hr = totalSeconds / 3600
    val min = totalSeconds % 3600 / 60
    val sec = totalSeconds % 60
    val result =
        if (hr == 0) "$min:${twoDigitPadStartZero(sec)}"
        else "$hr:${twoDigitPadStartZero(min)}:${twoDigitPadStartZero(sec)}"
    return result
}

private fun twoDigitPadStartZero(num: Int): String {
    return num.toString().padStart(2, '0')
}