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
    public CheckoutDataController()  {
        JdbcSQLiteConnection();
    }

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
                int statusInt = resultSet.getInt("status");
                boolean status;
                if (statusInt == 1){
                    status = true;
                } else {
                    status = false;
                }
                CheckOut checkOut = new CheckOut(id, date, appointmentBillId, recieverName, status);
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

    public void insertCheckout (String date, int appointmentBillId, String recieverName, int status) {
        try{
            connect();
            String query = "INSERT INTO checkout (date, appointment_bill_id, reciever_name, status) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, date);
            stmt.setInt(2, appointmentBillId);
            stmt.setString(3, recieverName);
            stmt.setInt(4, status);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editStatus (int checkoutId, int newStatus){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE checkout SET status = "+newStatus+" WHERE id = "+checkoutId);
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editReceiver (int checkoutId, String reseiverNme){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE checkout SET receiver_name = '"+reseiverNme+"' WHERE id = "+checkoutId);
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
