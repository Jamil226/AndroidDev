package com.mac.jamil.convertors

import androidx.room.TypeConverter
import java.util.Date

class Convertors {

    @TypeConverter
    fun dateToLong(value:Date): Long{
        return value.time
    }

    @TypeConverter
    fun longToDate(value:Long): Date{
        return Date(value)
    }
}