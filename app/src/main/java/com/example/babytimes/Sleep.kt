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
        //accepts user input and subtracts TimeAsleep from TimeWakeUp
        timeAsleep = findViewById(R.id.editTextTime3)
        timeWakeUp = findViewById(R.id.editTextTime2)
        var numAsleep = timeAsleep.text.toString().toFloat()
        var numWakeUp = timeWakeUp.text.toString().toFloat()
        val result = numWakeUp - numAsleep
        fridayHrs = fridayHrs.plus(result)
        //Call getBarChartData to update the chart
        getBarChartData(fridayHrs)
    }
    //Click listener that will navigate to main menu page when button (from layout) is clicked. Also requires activity entry in manifest
    fun mainMenu(view: View) {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }

    private fun getBarChartData(temp: Double) {
    // creates/ updates the bar chart

        //populate the bar chart with sample data
        //monday-friday variables represent the x-values in the chart
        //mondayHrs-firdayHrs represent the y-values in the chart
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

        // The bar chart we are importing from github does not support replacing values.
        //Therefore, if the chart has already been created, we'll all its values
        //before repopulating the chart below
        if (notEmpty)
        {
    barDataSet.removeLast()
            barDataSet.removeLast()
            barDataSet.removeLast()
            barDataSet.removeLast()
            barDataSet.removeLast()
            barDataSet.removeLast()
            /*Toast to show the calculated latest y-value from the entry
            val myToast =
                Toast.makeText(applicationContext, "temp = " + temp.toString(), Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT, 200, 200)
            myToast.show()*/
            barData.notifyDataChanged();
            barChart.notifyDataSetChanged();
            barChart.invalidate();
        }

        //populate the bar graph with monday-friday values
        barEntriesList.add(BarEntry(monday.toFloat(), mondayHrs.toFloat()))
        barEntriesList.add(BarEntry(tuesday.toFloat(), tuesdayHrs.toFloat()))
        barEntriesList.add(BarEntry(wednesday.toFloat(), wednesdayHrs.toFloat()))
        barEntriesList.add(BarEntry(thursday.toFloat(), thursdayHrs.toFloat()))
        //temp holds the difference between the two user-inputted values
        barEntriesList.add(BarEntry(friday.toFloat(), temp.toFloat()))

    //some settings for the bar chart
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


