package com.example.babytimes;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.SQLException // for database SQL functions

import android.os.Bundle;
import android.provider.ContactsContract
import android.service.autofill.UserData
import android.util.Log
import android.widget.TextView;
import androidx.core.content.ContextCompat.startActivity;
import java.sql.Timestamp
import java.time.LocalDateTime

class CreateAccount  : AppCompatActivity() {
    private val dbHelper = DatabaseHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.createaccount)

    }

    fun MainMenu (view: View) {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }

    //PUSH NEW USER
    fun NewUser() {
        Log.d("CreateAccount", "NewUser function called")
        val currentDateTime = LocalDateTime.now()
        val timestamp = Timestamp.valueOf(currentDateTime.toString()) // Convert LocalDateTime to a Timestamp
        insertUser("John", "Doe", timestamp, 0, "p@ssword", "jdoe@asu.edu")
    }
    // Create an instance of the DatabaseHelper class


    fun insertUser(firstName: String, lastName: String, createdDate: java.sql.Timestamp, isDeleted: Int, Password: String, Email: String) {
        val sql = "USE BabyTimes;" +
                "INSERT INTO users (FirstName, LastName, CreatedDate, IsDeleted, Password, Email) VALUES (?, ?, ?, ?, ?, ?)"

        try {
            val preparedStatement = dbHelper.connection.prepareStatement(sql)

            preparedStatement.setString(1, firstName)
            preparedStatement.setString(2, lastName)
            preparedStatement.setTimestamp(3, createdDate)
            preparedStatement.setInt(4, isDeleted)
            preparedStatement.setString(5, Password)
            preparedStatement.setString(6, Email)

            val rowsInserted = preparedStatement.executeUpdate()

            if (rowsInserted > 0) {
                println("User inserted successfully.")
            } else {
                println("Insertion failed.")
            }

            preparedStatement.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            dbHelper.closeConnection()
        }
        //MainMenu()
    }

}

