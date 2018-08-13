package com.pongi.cigarettescounter

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.pongi.cigarettescounter.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_chart.*


/**
 * A placeholder fragment containing a simple view.
 */
class ChartActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createBarChart()
    }

    private fun createBarChart() {
//        val barChart = findViewById(R.id.bar_chart) as BarChart

        val barChart = bar_chart
        if (bar_chart is BarChart) {

            val desc = Description()
            desc.text= "直近７日間"
            barChart.setDescription(desc)

            barChart.getAxisRight().setEnabled(false)
            barChart.getAxisLeft().setEnabled(true)
            barChart.setDrawGridBackground(true)
            barChart.setDrawBarShadow(false)
            barChart.setEnabled(true)

            barChart.setTouchEnabled(true)
            barChart.setPinchZoom(true)
            barChart.setDoubleTapToZoomEnabled(true)

            //barChart.setHighlightEnabled(true)
            //barChart.setDrawHighlightArrow(true)
            //barChart.setHighlightEnabled(true)

            barChart.setScaleEnabled(true)

            barChart.getLegend().setEnabled(true)

            //X軸周り
            val xAxisFormatter = DayAxisValueFormatter(barChart)

            val xAxis = barChart.getXAxis()
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
            //xAxis.setTypeface(mTfLight)
            xAxis.setDrawGridLines(false)
            xAxis.setGranularity(1f) // only intervals of 1 day
            xAxis.setLabelCount(7)
            xAxis.setValueFormatter(xAxisFormatter)

            barChart.setData(createBarChartData())

            barChart.invalidate()
            // アニメーション
            barChart.animateY(2000, Easing.EasingOption.EaseInBack)
        }
    }

    // BarChartの設定
    fun createBarChartData(): BarData {

        val barDataSets = ArrayList<IBarDataSet>()

        // valueA
        val valuesA = ArrayList<BarEntry>()
        valuesA.add(BarEntry(0f, 10f))
        valuesA.add(BarEntry(1f, 13f))
        valuesA.add(BarEntry(2f, 12f))
        valuesA.add(BarEntry(3f, 7f))
        valuesA.add(BarEntry(4f, 6f))
        valuesA.add(BarEntry(5f, 5f))
        valuesA.add(BarEntry(6f, 4f))

        val valuesADataSet = BarDataSet(valuesA, "一日の喫煙本数")
        valuesADataSet.setColor(ColorTemplate.COLORFUL_COLORS[3])

        barDataSets.add(valuesADataSet)
        val barData = BarData(barDataSets)
        barData.barWidth = 0.8f;
        return barData
    }
}
