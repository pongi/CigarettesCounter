package com.pongi.cigarettescounter.dao

import android.arch.persistence.room.*
import com.pongi.cigarettescounter.entity.SmokingLog

@Dao
interface SmokingLogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createLog(log: SmokingLog)

    @Query("SELECT * FROM SmokingLog")
    fun findAllLog(): List<SmokingLog>

    @Update
    fun updateLog(log: SmokingLog)

    @Delete
    fun deleteLog(log: SmokingLog)
}