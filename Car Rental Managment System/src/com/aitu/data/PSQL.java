package com.aitu.data;

import com.aitu.data.interfaces.IDB;

import java.sql.*;


public class PSQL implements IDB {
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "1234");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}