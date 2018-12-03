package Controller.dataController;

import Models.Reserve;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReserveDataController extends DatabaseConnection {
    TakingCarePetsListDataController takingCarePetsListDataController = new TakingCarePetsListDataController();
    public ArrayList<Reserve> getReserve() {
        ArrayList<Reserve> reserves = new ArrayList<>();
        try {
            connect();
            String query = "Select * from reserve";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date reserve_date = format.parse(resultSet.getString("reserve_date"));
                Date start_date = format.parse(resultSet.getString("start_date"));
                int number_of_reserve = resultSet.getInt("number_of_reserve");
                int customer_id = resultSet.getInt("customer_id");
                int pets_id = resultSet.getInt("taking_care_pets_id");
                double total_price = resultSet.getDouble("total_price");
                Reserve reserve = new Reserve(id, reserve_date, start_date, number_of_reserve, customer_id, pets_id);
                reserve.setPetsList(takingCarePetsListDataController.getTakingCarePetsList(customer_id));
                reserve.setTotal_price(total_price);
                reserves.add(reserve);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reserves;
    }

    public void insertReserve (String reserveDate, String startDate, int numberOfReserve, int customerId, int takingCarePetsId){
        try{
            String query = "INSERT INTO reserve (reserve_date, start_date, number_of_reserve, customer_id, pets_id) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, reserveDate);
            stmt.setString(2, startDate);
            stmt.setInt(3, numberOfReserve);
            stmt.setInt(4, customerId);
            stmt.setInt(5, takingCarePetsId);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTotalPrice (int reserveId, double totalPrice){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE reserve SET total_price = "+totalPrice+" WHERE id = '"+reserveId+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
