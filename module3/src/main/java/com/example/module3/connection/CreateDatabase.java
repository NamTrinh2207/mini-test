package com.example.module3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/employee_manager?useUnicode=yes&characterEncoding=UTF-8;";
    private static final String USER = "Nam";
    private static final String PASSWORD = "Anhnam220797anhnam";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dang ket noi toi co so du lieu ...");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Ket noi thanh cong");
        return connection;
    }
}