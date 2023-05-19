package com.aitu.utils;

import com.aitu.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface Control {
    List<Client> getAll() throws SQLException;
    void addClient() throws SQLException;
    void removeClient();
}
