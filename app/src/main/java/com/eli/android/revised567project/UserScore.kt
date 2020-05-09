package com.eli.android.revised567project

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class UserScore(@PrimaryKey val id: UUID=UUID.randomUUID(),
                     var userName: String = "",
                     var time: String = "",
                     var totalPoints: Long = 0) {}