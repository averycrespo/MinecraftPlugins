package com.ave.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Connects to database
public class Database {

    //Constants - local database >> would keep this in a config file if public
    private final String HOST = "localhost";
    private final int PORT = 3306;
    private final String DATABASE = "test_plugin";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                USERNAME, PASSWORD);
    }

    // If connection exists then return true
    public boolean isConnected() {
        return connection != null;
    }

    public void disconnect() {
        if( isConnected() ) {
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
