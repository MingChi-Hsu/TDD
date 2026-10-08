package com.mindyhsu.tdd

import com.mindyhsu.tdd.timeResume
import org.junit.Assert.assertEquals
import org.junit.Test

class VideoResumeTest {

    @Test
    fun `pause before the cast rolling and return the same time`() {
        val resumeTime = timeResume(1200, 3600)
        assertEquals(1200, resumeTime)
    }

    @Test
    fun `pause after the cast rolling and return to the beginning`() {
        val resumeTime = timeResume(3570, 3600)
        assertEquals(0, resumeTime)
    }
}