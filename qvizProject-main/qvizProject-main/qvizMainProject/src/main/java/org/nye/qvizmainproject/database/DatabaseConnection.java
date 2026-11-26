package org.nye.qvizmainproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/quiz_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // XAMPP-nál üres, MySQL Workbench-nél a saját jelszavad

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /* Gyors teszt: futtasd le ezt a fájlt jobb klikk -> Run
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Sikeres MySQL kapcsolat!");
        } catch (SQLException e) {
            System.out.println("Hiba a kapcsolódáskor: " + e.getMessage());
        }
    }*/
}