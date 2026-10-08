package com.mindyhsu.tdd

import com.mindyhsu.tdd.pickBitrate
import org.junit.Test
import org.junit.Assert.*

class BitratePickerTest {

    @Test
    fun `empty available list returns null`() {
        val result = pickBitrate(listOf(), 800)
        assertNull(result)
    }

    @Test
    fun `picks the highest bitrate that does not exceed network speed`() {
        val result = pickBitrate(listOf(300, 500, 1500), 800)
        assertEquals(500, result)
    }

    @Test
    fun `picks the highest bitrate that does not exceed network speed with unsorted list`() {
        val result = pickBitrate(listOf(1500, 300, 500), 800)
        assertEquals(500, result)
    }

    @Test
    fun `network speed lower than available list return lowest`() {
        val result = pickBitrate(listOf(300, 500, 1500), 200)
        assertEquals(300, result)
    }
}