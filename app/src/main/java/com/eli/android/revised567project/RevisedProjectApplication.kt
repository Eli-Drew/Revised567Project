package com.eli.android.revised567project

import android.app.Application

class RevisedProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        UserScoreRepository.initialize(this)
    }
}