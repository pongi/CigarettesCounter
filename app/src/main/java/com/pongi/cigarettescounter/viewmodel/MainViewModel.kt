package com.pongi.cigarettescounter.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.pongi.cigarettescounter.MyApplication
import com.pongi.cigarettescounter.entity.SmokingLog
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel: ViewModel() {

    /**
     * 現在日時をyyyy/MM/dd HH:mm形式で取得する.<br></br>
     */
    private fun getNowDate(): String {
        val df = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val date = Date(System.currentTimeMillis())
        return df.format(date)
    }

    var smokingLog = MyApplication.database.smokingLogDao().getLog()

    fun logging(log: SmokingLog) = async(CommonPool) {
        MyApplication.database.smokingLogDao().createLog(log)
        Log.d("sync", "createdb")
    }
}
