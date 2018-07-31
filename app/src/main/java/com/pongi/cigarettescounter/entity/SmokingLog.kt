package com.pongi.cigarettescounter.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
data class SmokingLog (
        @PrimaryKey
        val date: String,
        val lat: Double = 0.0,
        val lng: Double = 0.0,
        val count: Int
)