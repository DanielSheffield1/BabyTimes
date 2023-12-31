package com.example.babytimes;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity


class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

    }

    fun MainMenu (view: View) {
        val intent = Intent(this,MainMenu::class.java)
        startActivity(intent)
    }

    fun CreateAccount (view: View) {
        val intent = Intent(this,CreateAccount::class.java)
        startActivity(intent)
    }

    fun LogOut (view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}
