package com.example.babytimes

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class Diaper : AppCompatActivity() {

 //   lateinit var RadioGroup: radioGroup;
 //   lateinit var RadioButton: radioButton;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diaper)

      //  RadioGroup = findViewById(R.id.radioGroup);

     //   Button buttonApply = findViewById(R.id.submitData);
     //   buttonApply.setOnClickListener(new View.onClickListener()) {
     //       @override
     //       public void onClick(View v) {

    //        }
    //    }

    }

      /*  public void checkButton(View v) {

            var radioId = RadioGroup.getCheckedRadioButtonId();

                RadioButton = findViewByID(radioId);

        Toast.makeText(this, "Selected: " + RadioButton.getText(), Toast.LENGTH_SHORT)
        }
*/
    //Click listener that will navigate to main menu when button (from layout) is clicked. Also requires activity entry in manifest
    fun MainMenu (view: View) {
        val intent = Intent(this,MainMenu::class.java)
        startActivity(intent)
    }
}