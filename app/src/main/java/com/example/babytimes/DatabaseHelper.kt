package com.example.babytimes

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

class DatabaseHelper {
    internal var connection: Connection

    init {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver")
            /*adb.us-phoenix-1.oraclecloud.com is the database URL, 1522 is the port, gb844b0764eec32_babytimes_medium.adb.oraclecloud.com is the service name.*/
            val url = "jdbc:oracle:thin:@adb.us-phoenix-1.oraclecloud.com:1522/gb844b0764eec32_babytimes_medium.adb.oraclecloud.com"
            val username = "ADMIN"
            val password = "ift402Babytimes"
            connection = DriverManager.getConnection(url, username, password)
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
