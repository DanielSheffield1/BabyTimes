package com.example.babytimes

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.service.autofill.Dataset
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.ChartData
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter



class Sleep : AppCompatActivity() {

    lateinit var barChart: BarChart
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntriesList: ArrayList<BarEntry>
    var days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
    lateinit var button: Button
    public var fridayHrs = 0.0
    lateinit var timeAsleep:EditText
    lateinit var timeWakeUp:EditText
    var notEmpty: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sleep)
        getBarChartData(fridayHrs)



    }
    fun addSleepData(view: View?) {
        timeAsleep = findViewById(R.id.editTextTime3)
        timeWakeUp = findViewById(R.id.editTextTime2)
        var numAsleep = timeAsleep.text.toString().toFloat()
        var numWakeUp = timeWakeUp.text.toString().toFloat()
        val result = numWakeUp - numAsleep

        fridayHrs = fridayHrs.plus(result)
        /*//old check to see if accepting edit text and performing arithmetic was working correctly
        val myToast =
            Toast.makeText(applicationContext, "fridayHrs = " + fridayHrs.toString(), Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.LEFT, 200, 200)
        myToast.show()*/
        //redisplay the bar chart with the added sleep time
        getBarChartData(fridayHrs)
    }
    //Click listener that will navigate to main menu page when button (from layout) is clicked. Also requires activity entry in manifest
    fun mainMenu(view: View) {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }

    private fun getBarChartData(temp: Double) {

        val monday = 1
        val tuesday = 2
        val wednesday = 3
        val thursday = 4
        val friday = 5
        val mondayHrs = 9
        val tuesdayHrs = 9.5
        val wednesdayHrs = 11
        val thursdayHrs = 10

        barEntriesList = ArrayList()

        // on below line we are adding data
        // to our bar entries list
        if (notEmpty)
        {
    barDataSet.removeLast()
            barDataSet.removeLast()
            val myToast =
                Toast.makeText(applicationContext, "temp = " + temp.toString(), Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT, 200, 200)
            myToast.show()
            barData.notifyDataChanged();
            barChart.notifyDataSetChanged();
            barChart.invalidate();
        }
        barEntriesList.add(BarEntry(monday.toFloat(), mondayHrs.toFloat()))
        barEntriesList.add(BarEntry(tuesday.toFloat(), tuesdayHrs.toFloat()))
        barEntriesList.add(BarEntry(wednesday.toFloat(), wednesdayHrs.toFloat()))
        barEntriesList.add(BarEntry(thursday.toFloat(), thursdayHrs.toFloat()))
        barEntriesList.add(BarEntry(friday.toFloat(), temp.toFloat()))


        barChart = findViewById(R.id.sleepChart)
        barDataSet = BarDataSet(barEntriesList, "Hours of Sleep")
        barData = BarData(barDataSet)
        barChart.data = barData
        var xAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(days)
        barDataSet.setColor(Color.parseColor("#22B14C"))
        barDataSet.valueTextSize = 16f
        barChart.description.isEnabled = false
        notEmpty = true

    }


}


