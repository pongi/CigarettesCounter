package com.pongi.cigarettescounter

import android.app.Application
import android.arch.persistence.room.Room
import com.pongi.cigarettescounter.db.DataBase

class MyApplication: Application() {

    companion object {
        lateinit var database: DataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(applicationContext, DataBase::class.java, "db-master.db")
                .build()
    }
}
