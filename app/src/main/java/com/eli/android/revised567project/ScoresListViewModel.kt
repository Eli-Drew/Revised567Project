package com.eli.android.revised567project

import androidx.lifecycle.ViewModel

class ScoresListViewModel : ViewModel() {
    val scores = mutableListOf<UserScore>()
    init {
        var initTime = 5
        for (i: Int in 0 until 8) {
            val score = UserScore()
            initTime += i
            var stringTime = initTime.toString()
            score.time = stringTime
            score.totalPoints += i
        }
    }
}