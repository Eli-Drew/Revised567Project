package com.eli.android.revised567project

import java.util.*

data class UserScore(val id: UUID=UUID.randomUUID(), var userName: String = "", var time: String = "", var totalPoints: Int = 0) {}