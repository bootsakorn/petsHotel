package Controller.dataController;

import Models.CheckOut;
import javafx.stage.StageStyle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CheckoutDataController extends DatabaseConnection{
    public ArrayList<CheckOut> getCheckoutArrayList (){
        ArrayList<CheckOut> checkOutsArrayList = new ArrayList<>();
        try{
            connect();
            String query = "Select * from checkout";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            while (resultSet.next()){
                int id  = resultSet.getInt("id");
                String dateStr = resultSet.getString("date");
                Date date = format.parse(dateStr);
                int appointmentBillId = resultSet.getInt("appointment_bill_id");
                String recieverName = resultSet.getString("reciever_name");
                CheckOut checkOut = new CheckOut(id, date, appointmentBillId, recieverName);
                checkOutsArrayList.add(checkOut);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return checkOutsArrayList;
    }

    public void insertCheckout (String date, int appointmentBillId, String recieverName) {
        try{
            connect();
            String query = "INSERT INTO checkout (date, appointment_bill_id, reciever_name) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, date);
            stmt.setInt(2, appointmentBillId);
            stmt.setString(3, recieverName);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
