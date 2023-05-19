package repositories.Impl;

import com.aitu.data.PSQL;
import repositories.Rental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.aitu.utils.Input.in;



public class RentalImpl implements Rental {

    private CarRepositoryImpl carRepository = new CarRepositoryImpl();

    private static PSQL psql = new PSQL();


    @Override
    public void rentalCar() throws SQLException {
        Connection connection = psql.getConnection();
        System.out.println("firstly you have to log in to our system by your name");
        String name = in.next();
        ResultSet resultSetUser = ClientRepositoryImpl.getCertain(name);


        if (!resultSetUser.next()) {
            System.out.println("incorrect name");
            return;
        }

        int balance = resultSetUser.getInt("balance");

        System.out.println("enter brand");
        String brand = in.next();
        System.out.println("enter model");
        String model = in.next();
        ResultSet resultSetTicket = carRepository.getCertain(brand, model);


        if (!resultSetTicket.next()) {
            System.out.println("car does not founded");
            return;
        }


        model = resultSetTicket.getString("model");
        String color = resultSetTicket.getString("color");
        String type = resultSetTicket.getString("type");
        int price = resultSetTicket.getInt("price");


        if (price > balance) {
            System.out.println("not enough money");
            return;
        }

        Statement statement = connection.createStatement();


        statement.executeUpdate("update test set balance = " + (balance - price));


        String sql = "insert into orders(name, brand, model, color, type, price) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, brand);
        preparedStatement.setString(3, model);
        preparedStatement.setString(4, color);
        preparedStatement.setString(5, type);
        preparedStatement.setInt(6, price);


        preparedStatement.executeUpdate();


        resultSetTicket.close();
        resultSetUser.close();
        preparedStatement.close();
        statement.close();
        connection.close();


        System.out.println("have a good trip");


    }

    public static List<String> getClientCar(String name) throws SQLException {
        Connection connection = psql.getConnection();
        String sql = "select * from orders where name = '" + name + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<String> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(
                    "["  +    resultSet.getString("brand") + " "
                            + resultSet.getString("model") + " "
                            + resultSet.getString("color") + " "
                            + resultSet.getString("type") + " "
                            + resultSet.getInt("price") + "]"
            );
        }


        resultSet.close();
        statement.close();
        connection.close();

        return list;

    }

}
