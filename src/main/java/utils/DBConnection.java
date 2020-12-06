package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "airline2";
    private static final String DB_USER_NAME = "root";
    private static final String DB_PASSWORD = "admin";
    private static final String OPTIONS = "?serverTimezone=Europe/Minsk&allowMultiQueries=true";

    private static Connection connection;

    public static Connection connect() throws Exception {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL + DB_NAME + OPTIONS, DB_USER_NAME, DB_PASSWORD);
                System.out.println("Connected to " + DB_NAME);
            } catch (Exception e) {
                System.out.println("Error connecting to " + DB_NAME);
                throw new Exception(e);
            }
        }
        return connection;
    }

    public static void disconnect() throws Exception {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
                System.out.println("Disconnected from " + DB_NAME);
            } catch (Exception e) {
                System.out.println("Error disconnecting from " + DB_NAME);
                throw new Exception(e);
            }
        }
    }
}
