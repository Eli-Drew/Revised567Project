package com.eli.android.revised567project

import androidx.lifecycle.ViewModel

class ScoresListViewModel : ViewModel() {
    var scores = mutableListOf<UserScore>()
    var initTime = 5
    init {

        for (i: Int in 0 until 8) {
            val score = UserScore()
            initTime += i
            val stringTime = initTime.toString()
            score.time = stringTime
            score.totalPoints = i + 5
            score.userName = "username"
            scores.plusAssign(score)
        }
    }
}