package com.example.babytimes

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.os.Bundle;

class Food : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food)

        //Reference String Array
        val type = resources.getStringArray(R.array.Type)
        //pass parameter
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_food, type)
        //Reference autocomplete text view
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.auto_complete_txt)
        //set autocompleteTV to arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)

    }

    //Click listener that will navigate to main menu when button (from layout) is clicked. Also requires activity entry in manifest
    fun MainMenu(view: View) {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }

}