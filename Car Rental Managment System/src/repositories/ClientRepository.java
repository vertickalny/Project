package repositories;

import com.aitu.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientRepository {

    List<Client> getAll() throws SQLException;

    void add() throws SQLException;

    void delete() throws SQLException;
}
