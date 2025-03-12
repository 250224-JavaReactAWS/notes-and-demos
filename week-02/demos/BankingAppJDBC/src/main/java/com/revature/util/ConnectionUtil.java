package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    /*
    The ConnectionUtil is a utility class that will allow me to retrieve a connection to the database and
    execute queries against it.

    Setting up a Database Connection is relatively costly compared to executing statement
    -> When doing JDBC, generally the largest amount of time is dedicated to setting up a connection

    We're going to build this class as a SINGLETON INSTANCE. Singleton is a design pattern where there is only
    ever one single object in existence and if you need it you'll return the existing object
     */

    // Private static instance of the connection
    // Connection interface represents physical connection to the database
    private static Connection conn = null;

    // Private constructor
    private ConnectionUtil(){
        // Having this be private means NOBODY can make an instance of this class at all
    }

    // Public static getInstance method
    public static Connection getConnection(){
        // If a connection already exists, we return it
        // Let's check to see if there is an existing connection
        try {
            if (conn != null && !conn.isClosed()){
                return conn;
            }
        } catch (SQLException e) {
            // This was an auto generated block
            e.printStackTrace();
            return null;
        }

        // Otherwise we create a new connection

        // To create a new connection we need a few things
        // Database location (URL)
        // Database Username
        // Database password
        // Driver class to connect to it

        // URL will be a JDBC url
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String username = "postgres";
//        String password = "password";

        // We're going to hide the above information in a properties file
        String url;
        String username;
        String password;

        Properties props = new Properties();


        // Use the DriverManager to set up a connection
        try {
            // Load the properties file
            props.load(new FileReader("src/main/resources/application.properties"));

            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");


            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not establish connection!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Could not establish connection!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not establish connection!");
        }

        return conn;
    }
}
