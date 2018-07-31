package com.pongi.cigarettescounter

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pongi.cigarettescounter.entity.SmokingLog
import com.pongi.cigarettescounter.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { activity ->
            val viewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)

            view.button.setOnClickListener{
                viewModel.logging(SmokingLog(date = getNowDate(), count = 1))
            }
        }
    }

    /**
     * 現在日時をyyyy/MM/dd HH:mm形式で取得する.<br></br>
     */
    private fun getNowDate(): String {
        val df = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val date = Date(System.currentTimeMillis())
        return df.format(date)
    }
}
