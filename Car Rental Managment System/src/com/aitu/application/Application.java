package com.aitu.application;

import java.sql.SQLException;

public interface Application {
    void start() throws SQLException;
    default void exit(){
        System.out.println("app closing");
        System.exit(0);
    }
}
