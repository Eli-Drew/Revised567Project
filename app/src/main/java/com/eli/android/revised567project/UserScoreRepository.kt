package com.eli.android.revised567project

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.eli.android.revised567project.quizScoreDatabase.UserScoreDao
import com.eli.android.revised567project.quizScoreDatabase.UserScoreDatabase
import java.lang.Exception
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

private const val DATABASE_NAME = "userScore_Database"

class UserScoreRepository private constructor(context: Context){

    private val database: UserScoreDatabase = Room.databaseBuilder(
        context.applicationContext,
        UserScoreDatabase::class.java,
        DATABASE_NAME).build()

    private val userScoreDao = database.userScoreDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getUserScores() : LiveData<List<UserScore>> = userScoreDao.getUserScores()
    fun getUserScore(id: UUID) : LiveData<UserScore?> = userScoreDao.getUserScore(id)
//    fun removeScore(id: UUID) : LiveData<UserScore> = userScoreDao.removeUserScore(id)

    fun addUserScore(score: UserScore) {
        executor.execute {
            userScoreDao.addScore(score)
        }
    }

    fun deleteUserScore(score: UserScore) {
        executor.execute {
            userScoreDao.deleteScore(score)
        }
    }


    companion object {
        private var INSTANCE: UserScoreRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = UserScoreRepository(context)
            }
        } // end of initialize()

        fun get() : UserScoreRepository {
            return INSTANCE ?:
                    throw IllegalStateException("UserRepository must be initialized.")
        }
    }
}