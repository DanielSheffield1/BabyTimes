package com.example.babytimes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddUserActivity extends AppCompatActivity {

    EditText firstName_input, lastName_input, email_input, username_input, password_input;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstName_input = findViewById(R.id.firstName_input);
        lastName_input = findViewById(R.id.lastName_input);
        email_input = findViewById(R.id.email_input);
        username_input = findViewById(R.id.username_input);
        password_input = findViewById(R.id.password_input);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper myDB = new DatabaseHelper(AddUserActivity.this);
                myDB.addUser(firstName_input.getText().toString().trim(),
                        lastName_input.getText().toString().trim(),
                        email_input.getText().toString().trim(),
                        username_input.getText().toString().trim(),
                        password_input.getText().toString().trim());
            }

        });
    }
}