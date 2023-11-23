package com.example.babytimes

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

import android.os.Bundle;
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class Sleep : AppCompatActivity() {

    lateinit var barChart: BarChart
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntriesList: ArrayList<BarEntry>
    var days = arrayOf("Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sleep)
        barChart = findViewById(R.id.sleepChart)
        getBarChartData()
        barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")
        barData = BarData(barDataSet)
        barChart.data = barData
        var xAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(days)
        barDataSet.setColor(resources.getColor(R.color.purple_200))
        barDataSet.valueTextSize = 16f
        barChart.description.isEnabled = false


    }

    //Click listener that will navigate to main menu page when button (from layout) is clicked. Also requires activity entry in manifest
    fun mainMenu(view: View) {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }
        private fun getBarChartData() {
            barEntriesList = ArrayList()

            // on below line we are adding data
            // to our bar entries list
            barEntriesList.add(BarEntry(1f, 1f))
            barEntriesList.add(BarEntry(2f, 2f))
            barEntriesList.add(BarEntry(3f, 3f))
            barEntriesList.add(BarEntry(4f, 4f))
            barEntriesList.add(BarEntry(5f, 5f))

        }

    }