package Controller.dataController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookingDataController extends DatabaseConnection {

    public ArrayList<ArrayList<String>> getCustomers () {
        ArrayList<ArrayList<String>> customers = new ArrayList<>();
        try {
            connect();
            String query = "Select * from customers";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ArrayList<String> customer = new ArrayList<>();
                String id = String.valueOf(resultSet.getInt("ig"));
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                customer.add(id);
                customer.add(firstname);
                customer.add(lastname);
                customer.add(address);
                customers.add(customer);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public ArrayList<Integer> getPetsList (int customer_id){
        ArrayList<Integer> petsList = new ArrayList<>();
        try {
            connect();
            String query = "Select pet_id from pets_list where customer_id='"+customer_id+"'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer petId = resultSet.getInt("pet_id");
                petsList.add(petId);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petsList;
    }
}
