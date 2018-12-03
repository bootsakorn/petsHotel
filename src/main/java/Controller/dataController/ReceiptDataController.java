package Controller.dataController;

import Models.Receipt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReceiptDataController extends DatabaseConnection {
    public ReceiptDataController() throws ClassNotFoundException {
        JdbcSQLiteConnection();
    }
    public ArrayList<Receipt> getReceipts (){
        ArrayList<Receipt> receipts = new ArrayList<>();
        try{
            connect();
            String query = "Select * from reciept";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String dateStr = resultSet.getString("date");
                Date date = format.parse(dateStr);
                int checkinId = resultSet.getInt("checkin_id");
                double totalPrice = resultSet.getDouble("total_price");
                double recieve = resultSet.getDouble("recieve");
                double change = resultSet.getDouble("change");
                Receipt receipt = new Receipt(id, date, checkinId, totalPrice, recieve, change);
                receipts.add(receipt);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return receipts;
    }

    public void insertReceipt (String date, int checkinId, double totalPrice, double recieve, double change){
        try {
            connect();
            String query = "INSERT INTO receipt (date, checkin_id, total_price, recieve, change) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, date);
            stmt.setInt(2, checkinId);
            stmt.setDouble(3, totalPrice);
            stmt.setDouble(4, recieve);
            stmt.setDouble(5, change);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
