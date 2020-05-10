package com.eli.android.revised567project

import androidx.lifecycle.ViewModel

class ScoresListViewModel : ViewModel() {

    private val userScoreRepository = UserScoreRepository.get()
    val scoresListLiveData = userScoreRepository.getUserScores()

    fun saveUserScore(score: UserScore) {
        userScoreRepository.addUserScore(score)
    }

    fun removeUserScore(score: UserScore) {
        userScoreRepository.removeScore(score.id)
    }
}