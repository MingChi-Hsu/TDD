package com.mindyhsu.tdd

private const val ALL_PINS = 10
private const val FRAMES_PER_GAME = 10

class Game {
    private val rolls = mutableListOf<Int>()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var total = 0
        var frameStart = 0
        var frame = 0

        // A game has at most 10 frames. Any rolls after the 10th frame are bonus rolls, already counted as part of the 10th frame.
        while (frameStart < rolls.size && frame < FRAMES_PER_GAME) {
            when {
                isStrike(frameStart) -> {
                    total += pinsAt(frameStart) + pinsAt(frameStart + 1) + pinsAt(frameStart + 2)
                    frameStart += 1
                }

                isSpare(frameStart) -> {
                    total += pinsAt(frameStart) + pinsAt(frameStart + 1) + pinsAt(frameStart + 2)
                    frameStart += 2
                }

                else -> {
                    total += pinsAt(frameStart) + pinsAt(frameStart + 1)
                    frameStart += 2
                }
            }

            frame += 1
        }
        return total
    }

    // Returns 0 for a roll that hasn't happened yet, e.g. the bonus rolls after a strike in an unfinished game.
    private fun pinsAt(index: Int) = rolls.getOrElse(index) { 0 }

    private fun isStrike(frameStart: Int) = pinsAt(frameStart) == ALL_PINS

    private fun isSpare(frameStart: Int) = pinsAt(frameStart) + pinsAt(frameStart + 1) == ALL_PINS
}