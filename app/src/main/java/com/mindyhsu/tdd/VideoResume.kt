package com.mindyhsu.tdd

fun timeResume(pauseTime: Int, videoLength: Int): Int =
    if (videoLength - pauseTime > 30) pauseTime else 0