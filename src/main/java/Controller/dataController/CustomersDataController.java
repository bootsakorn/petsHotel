package Controller.dataController;

import Models.Customer;
import Models.Food;
import Models.Pets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomersDataController extends DatabaseConnection {
    public CustomersDataController() {
        JdbcSQLiteConnection();
    }

    private PetsListDataController petsListDataController = new PetsListDataController();
    public ArrayList<Customer> getCustomers () {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            connect();
            String query = "Select * from customers";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, firstname, lastname, address);
                customers.add(customer);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void insertCustomer(String firstname, String lastname, String address) {
        try {
            connect();
            String query = "INSERT INTO customers (firstname,lastname,address) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, address);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
