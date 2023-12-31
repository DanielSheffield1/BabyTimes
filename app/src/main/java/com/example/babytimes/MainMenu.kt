package com.example.babytimes

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainmenu)

    }

    //Click listener that will navigate to Food page when button (from layout) is clicked. Also requires activity entry in manifest
    fun Food (view: View) {
        val intent = Intent(this,Food::class.java)
        startActivity(intent)
    }

    //Click listener that will navigate to Sleep page when button (from layout) is clicked. Also requires activity entry in manifest
    fun Sleep (view: View) {
        val intent = Intent(this,Sleep::class.java)
        startActivity(intent)
    }

    //Click listener that will navigate to Diaper page when button (from layout) is clicked. Also requires activity entry in manifest
    fun Diaper (view: View) {
        val intent = Intent(this,Diaper::class.java)
        startActivity(intent)
    }

    //Click listener that will navigate to Settings page when button (from layout) is clicked. Also requires activity entry in manifest
    fun Settings (view: View) {
        val intent = Intent(this,Settings::class.java)
        startActivity(intent)
    }
}