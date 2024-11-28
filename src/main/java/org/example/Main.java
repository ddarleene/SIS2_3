package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:employees.db";
        try (Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS employees (id INTEGER PRIMARY KEY, first TEXT, last TEXT, age INTEGER)");
            stmt.execute("INSERT INTO employees (first, last, age) VALUES ('Ruslan', 'Ivanov', 27)");
            stmt.execute("INSERT INTO employees (first, last, age) VALUES ('Sayat', 'Sadykov', 25)");
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("first") + " " + rs.getString("last") + ", Age: " + rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
