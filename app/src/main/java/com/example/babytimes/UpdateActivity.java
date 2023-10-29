package com.example.babytimes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.babytimes.DatabaseHelper;

public class UpdateActivity extends AppCompatActivity {

    EditText firstName_input, lastName_input, email_input, username_input, password_input;
    Button update_button, delete_button;

    String id, firstName, lastName, email, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        firstName_input = findViewById(R.id.firstName_input2);
        lastName_input = findViewById(R.id.lastName_input2);
        email_input = findViewById(R.id.email_input2);
        username_input = findViewById(R.id.username_input2);
        password_input = findViewById(R.id.password_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(firstName + "/'s Account");
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                DatabaseHelper myDB = new DatabaseHelper(UpdateActivity.this);
                firstName = firstName_input.getText().toString().trim();
                lastName = lastName_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                username = username_input.getText().toString().trim();
                password = password_input.getText().toString().trim();
                myDB.updateData(id, firstName, lastName, email, username, password);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("firstName") &&
                getIntent().hasExtra("lastName") && getIntent().hasExtra("email") && getIntent().hasExtra("username")
                && getIntent().hasExtra("password")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            firstName = getIntent().getStringExtra("firstName");
            lastName = getIntent().getStringExtra("lastName");
            email = getIntent().getStringExtra("email");
            username = getIntent().getStringExtra("username");
            password = getIntent().getStringExtra("password");

            //Setting Intent Data
            firstName_input.setText(firstName);
            lastName_input.setText(lastName);
            email_input.setText(email);
            username_input.setText(username);
            password_input.setText(password);
            Log.d("Danny",firstName+" "+lastName+" "+email+" "+username+" "+password);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + firstName + "'s account?");
        builder.setMessage("Are you sure you want to delete " + firstName + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}