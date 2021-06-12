package com.demo.warehouse.MyExcelDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServiceDB {

    private static final String url = "jdbc:mysql://warehouse.c08t4w8hsoyc.eu-central-1.rds.amazonaws.com:3306/warehouse?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "password";
    private static Connection myConnection = null;

    public static Connection getConnection(){
        if (myConnection == null) {
            try {
                myConnection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return myConnection;
    }
}
