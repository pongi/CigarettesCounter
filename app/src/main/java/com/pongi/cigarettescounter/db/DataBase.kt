package com.pongi.cigarettescounter.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pongi.cigarettescounter.dao.SmokingLogDao
import com.pongi.cigarettescounter.entity.SmokingLog

@Database(entities = arrayOf(SmokingLog::class), version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun smokingLogDao(): SmokingLogDao
}