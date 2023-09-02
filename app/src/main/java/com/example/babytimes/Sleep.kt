package com.example.babytimes

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class Sleep : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sleep)

    }

    //Click listener that will navigate to main menu page when button (from layout) is clicked. Also requires activity entry in manifest
    fun mainMenu(view: View) {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }
}