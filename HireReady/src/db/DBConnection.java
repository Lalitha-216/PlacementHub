package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placementHub",
                    "root",
                    "Varshini@707"
            );

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return conn;
    }
}