package com.example.babytimes

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.util.Properties
import android.os.StrictMode
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

import java.sql.Statement


class DatabaseHelper {
    internal var connection: Connection

    init {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver")

            // Specify the wallet location
            val walletLocation = "/wallet"

            // Set up connection properties
            val properties = Properties()
            properties.setProperty("user", "ADMIN")
            properties.setProperty("password", "ift402Babytimes")
            properties.setProperty("oracle.net.wallet_location", "(SOURCE=(METHOD=file)(METHOD_DATA=(DIRECTORY=$walletLocation)))")

            // Establish the connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.us-phoenix-1.oraclecloud.com))(connect_data=(service_name=gb844b0764eec32_babytimes_medium.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))", properties)
        } catch (e: ClassNotFoundException) {
            throw SQLException("Oracle JDBC driver not found.")
        } catch (e: SQLException) {
            throw SQLException("Failed to connect to the database.")
        }
    }

    fun executeQuery(sql: String): ResultSet? {
        try {
            connection.let { conn ->
                val statement = conn.prepareStatement(sql)
                return statement.executeQuery()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return null
    }

    fun executeUpdate(sql: String): Int {
        try {
            connection.let { conn ->
                val statement = conn.prepareStatement(sql)
                return statement.executeUpdate()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return -1
    }


    fun closeConnection() {
        try {
            connection.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}
