package com.eli.android.revised567project.quizScoreDatabase

import androidx.room.TypeConverter
import java.util.*

class UserScoreTypeConverters {

    @TypeConverter
    fun toUUID(uuid: String?) : UUID? {
        return UUID.fromString(uuid)
    } // end of toUUID()

    @TypeConverter
    fun fromUUID(uuid: UUID) : String? {
        return uuid.toString()
    } // end of fromUUID()

    // I will have to figure out how to represent time in the database
//    @TypeConverter
//    fun toTime(time: ) :   {
//
//    }

//    @TypeConverter
//    fun fromTime(time:  ) :  {
//
//    }
}