package com.hrm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/hrm_db?useSSL=false";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "manager";

    static Connection conn = null;

    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            System.out.println("Connecting to database..."); 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connection Success!");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void disconnect() {
        if (conn != null) {            
            try {
                System.out.println("Disconnecting...."); 
                conn.close();
                System.out.println("Disconnected successfully!");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
