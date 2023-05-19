package repositories.Impl;

import com.aitu.data.PSQL;
import com.aitu.entities.Client;
import repositories.ClientRepository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import static com.aitu.utils.Input.in;

public class ClientRepositoryImpl  implements ClientRepository {

    private static PSQL psql = new PSQL();


    @Override
    public List<Client> getAll() throws SQLException {
        Connection connection = psql.getConnection();
        List<Client> clients = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test");
        while (resultSet.next()){
            clients.add(new Client(
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("gender"),
                    resultSet.getInt("balance"),
                    RentalImpl.getClientCar(resultSet.getString("name"))
            ));
        }

        statement.close();
        resultSet.close();
        connection.close();

        return clients;
    }



    @Override
    public void add() throws SQLException {
        Connection connection = psql.getConnection();
        System.out.println("enter name");
        String name = in.next();
        System.out.println("enter age");
        int age = in.nextInt();
        System.out.println("enter gender");
        String gender = in.next();
        System.out.println("enter balance");
        int balance = in.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into test (name,age,gender,balance) values (?,?,?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, gender);
        preparedStatement.setInt(4, balance);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

        System.out.println("user added");

    }

    @Override
    public void delete() throws SQLException {
        Connection connection = psql. getConnection () ;
        System.out.println("enter user name for deleting");
        String name = in. next();
        Statement statement = connection.createStatement();
        ResultSet s = getCertain(name);
        if (!s.next()){
            System.out.println("user does not founded");
            return;
        }
        String userName = s.getString("name");
        System.out.println("Enter 1 for confirm action");
        String one = in.next();
        if(!one.equals ("1")) {
            System.out.println("Action cancelled");
            return;
        }
            statement.executeUpdate("delete from test where name = '" + userName + "'");
            statement.executeUpdate("delete from orders where name = '" + userName + "'");
            s.close();
            statement.close();
            connection.close();
            System.out.println("user was deleted");

        }


    public static ResultSet getCertain(String name) throws SQLException {
        Connection connection = psql.getConnection();
        String searchClient = "select * from test where name ='" + name + "'";
        Statement statement = connection. createStatement ();
        ResultSet s = statement.executeQuery(searchClient);
        return s;
}
    }

