/*
Hello World!
Add your name here so we know you can collaborate with the project successfully:

Daniel Sheffield
Kiersten McWilliams
Kyle Becker
Alexander Hays

 */




package com.example.babytimes

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.core.content.ContextCompat.startActivity
import com.example.babytimes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //Click listener that will navigate to main menu when button (from layout) is clicked. Also requires activity entry in manifest
    fun MainMenu (view: View) {
        val intent = Intent(this,MainMenu::class.java)
        startActivity(intent)
    }

    //Click listener that will navigate to Create Account when button (from layout) is clicked. Also requires activity entry in manifest
    fun CreateAccount (view: View) {
        val intent = Intent(this,CreateAccount::class.java)
        startActivity(intent)
    }
}
