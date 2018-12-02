package Controller.dataController;

import Models.Pets;
import Models.Reserve;
import Models.TakingCarePetsList;

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
                double pledge = resultSet.getDouble("pledge");
                double total_price = resultSet.getDouble("total_price");
                Reserve reserve = new Reserve(id, reserve_date, start_date, number_of_reserve, customer_id, pets_id, pledge, total_price);
                reserve.setPetsList(takingCarePetsListDataController.getTakingCarePetsList(customer_id));
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

}
