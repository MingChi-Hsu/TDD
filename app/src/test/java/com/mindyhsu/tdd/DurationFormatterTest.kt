package com.mindyhsu.tdd

import com.mindyhsu.tdd.formatDuration
import org.junit.Test

import org.junit.Assert.*

class DurationFormatterTest {
    @Test
    fun `formats zero as 0 colon 00`() {
        assertEquals("0:00", formatDuration(0))
    }

    @Test
    fun `pads seconds with a leading zero`() {
        assertEquals("0:05", formatDuration(5))
    }

    @Test
    fun `two digit seconds format`() {
        assertEquals("0:10", formatDuration(10))
    }

    @Test
    fun `no pads minutes with a leading zero`() {
        assertEquals("1:05", formatDuration(65))
    }

    @Test
    fun `includes hours when duration is an hour or longer`() {
        assertEquals("1:05:00", formatDuration(3900))
    }

    @Test
    fun `throws for negative duration`() {
        assertThrows(IllegalArgumentException::class.java) {
            formatDuration(-1)
        }
    }
}