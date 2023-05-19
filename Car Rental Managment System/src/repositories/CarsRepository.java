package repositories;

import com.aitu.entities.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarsRepository {
    void add() throws SQLException;
    List<Car> getAll() throws SQLException;
}
