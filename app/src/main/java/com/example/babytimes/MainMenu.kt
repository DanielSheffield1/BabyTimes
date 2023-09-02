package com.example.babytimes

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainmenu)

    }

    fun Food (view: View) {
        val intent = Intent(this,Food::class.java)
        startActivity(intent)
    }
    fun Sleep (view: View) {
        val intent = Intent(this,Sleep::class.java)
        startActivity(intent)
    }
    fun Diaper (view: View) {
        val intent = Intent(this,Diaper::class.java)
        startActivity(intent)
    }
}