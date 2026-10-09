package com.mindyhsu.tdd

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class GameTest {

    private lateinit var game: Game

    @Before
    fun setUp() {
        game = Game()
    }

    @Test
    fun `one pins`() {
        rollMany(1, 1)
        val score = game.score()
        assertEquals(1, score)
    }

    @Test
    fun `ten pins`() {
        rollMany(1, 10)
        val score = game.score()
        assertEquals(10, score)
    }

    @Test
    fun `one pins for ten rolls`() {
        rollMany(10, 1)
        val score = game.score()
        assertEquals(10, score)
    }

    @Test
    fun `one spare`() {
        rollMany(1, 7)
        rollMany(1, 3)
        rollMany(8, 1)
        val score = game.score()
        assertEquals(19, score)
    }

    @Test
    fun `ten across two frames`() {
        rollMany(2, 2)
        rollMany(1, 8)
        rollMany(7, 1)
        val score = game.score()
        assertEquals(19, score)
    }

    @Test
    fun `one strike in first frame`() {
        rollMany(1, 10)
        rollMany(8, 1)
        val score = game.score()
        assertEquals(20, score)
    }

    @Test
    fun `one strike in later frame`() {
        rollMany(2, 1)
        rollMany(1, 10)
        rollMany(6, 1)
        val score = game.score()
        assertEquals(20, score)
    }

    @Test
    fun `one strike then one spare`() {
        rollMany(2, 1)
        rollMany(1, 10)
        rollMany(1, 3)
        rollMany(1, 7)
        rollMany(4, 1)
        val score = game.score()
        assertEquals(37, score)
    }

    @Test
    fun `perfect game`() {
        rollMany(12, 10)
        val score = game.score()
        assertEquals(300, score)
    }

    @Test
    fun `score called twice`() {
        rollMany(12, 10)
        val score = game.score()
        val score2 = game.score()
        assertEquals(300, score)
        assertEquals(300, score2)
    }

    private fun rollMany(times: Int, pins: Int) {
        repeat(times) { game.roll(pins) }
    }
}