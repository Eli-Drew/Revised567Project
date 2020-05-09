package com.eli.android.revised567project.quizScoreDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.eli.android.revised567project.UserScore
import java.util.*

@Dao
interface UserScoreDao {

    @Query("SELECT * FROM userscore WHERE id=(:id)")
    fun getUserScore(id: UUID) : LiveData<UserScore?>

    @Query("SELECT * FROM userscore")
    fun getUserScores(): LiveData<List<UserScore>>

    // I'm not sure we'll need this functionality.
    @Update
    fun updateScore(score: UserScore)

    @Insert
    fun addScore(score: UserScore)
}