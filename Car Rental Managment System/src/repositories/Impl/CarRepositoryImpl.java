package repositories.Impl;

import com.aitu.data.PSQL;
import com.aitu.entities.Car;
import repositories.CarsRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.aitu.utils.Input.in;


public class CarRepositoryImpl implements CarsRepository {
    private static PSQL psql = new PSQL();

    public void add() throws SQLException {
        Connection connection = psql.getConnection();

        System.out.println("enter brand");
        String brandType = in.next();
        System.out.println("enter model");
        String model = in.next();
        System.out.println("enter color");
        String color = in.next();
        System.out.println("enter type");
        String type = in.next();
        System.out.println("enter price");
        int price = in.nextInt();

        String add = "insert into cars ( model, color, type,price,brand) values (?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(add);

        preparedStatement.setString(1, model);
        preparedStatement.setString(2, color);
        preparedStatement.setString(3, type);
        preparedStatement.setInt(4, price);
        preparedStatement.setString(5,brandType);

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();

        System.out.println("Car added");
    }


    public static ResultSet getCertain(String brand, String model) throws SQLException {
        Connection connection = psql.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from cars where brand  ='" + brand + "'" + " and model ='" + model + "'");
        return resultSet;
    }

    public  List<Car> getAll() throws SQLException {

        Connection connection = psql.getConnection();
        List<Car> cars = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from cars");
        while (resultSet.next()) {
            cars.add(new Car(
                    resultSet.getString("brand"),
                    resultSet.getString("model"),
                    resultSet.getString("color"),
                    resultSet.getString("type"),
                    resultSet.getInt("price")
            ));
        }
        return cars;
    }

}