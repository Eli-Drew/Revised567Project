package com.eli.android.revised567project.quizScoreDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eli.android.revised567project.UserScore
import java.util.*

@Dao
interface UserScoreDao {

    @Query("SELECT * FROM userscore WHERE id=(:id)")
    fun getUserScore(id: UUID) : LiveData<UserScore?>

    @Query("SELECT * FROM userscore")
    fun getUserScores(): LiveData<List<UserScore>>

//    @Query("DELETE FROM UserScore WHERE id=(:id)")
//    fun removeUserScore(id: UUID) : LiveData<UserScore>

    @Update
    fun updateScore(score: UserScore)

    @Insert
    fun addScore(score: UserScore)

    @Delete
    fun deleteScore(score: UserScore)
}