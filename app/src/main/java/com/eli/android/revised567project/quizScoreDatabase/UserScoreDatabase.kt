package com.eli.android.revised567project.quizScoreDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eli.android.revised567project.UserScore

@Database(entities = [ UserScore::class ], version = 1)
@TypeConverters(UserScoreTypeConverters::class)
abstract class UserScoreDatabase : RoomDatabase() {

    abstract fun userScoreDao(): UserScoreDao
}