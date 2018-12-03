package Controller.dataController;

import Models.CheckIn;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SplittableRandom;

public class CheckInDataController extends DatabaseConnection {
    public CheckInDataController() throws ClassNotFoundException {
        JdbcSQLiteConnection();
    }

    public ArrayList<CheckIn> getCheckInList(){
        ArrayList<CheckIn> checkInArrayList = new ArrayList<>();
        try {
            connect();
            String query = ("Select * from checkin");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String date_str = resultSet.getString("date");
                Date date = format.parse(date_str);
                int reserveId = resultSet.getInt("reserve_id");
                int appointmentBillId = resultSet.getInt("appointment_bill_id");
                int receiptId = resultSet.getInt("receipt_id");
                CheckIn checkIn = new CheckIn(id, date, reserveId, appointmentBillId, receiptId);
                checkInArrayList.add(checkIn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return checkInArrayList;
    }

    public void insertCheckin (String date, int reserveId, int appointmentId, int receiptId){
        try{
            String query = "INSERT INTO checkin (date,reserve_id,appointment_id, receipt_id) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, date);
            stmt.setInt(2, reserveId);
            stmt.setInt(3, appointmentId);
            stmt.setInt(4, receiptId);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
