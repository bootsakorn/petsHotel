package Controller.dataController;

import Models.CheckOut;
import javafx.stage.StageStyle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CheckoutDataController extends DatabaseConnection{
    public ArrayList<CheckOut> getCheckoutArrayList (){
        ArrayList<CheckOut> checkOutsArrayList = new ArrayList<>();
        try{
            connect();
            String query = "Select * from checkout";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkOutsArrayList;
    }
}
