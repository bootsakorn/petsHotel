package Controller.dataController;

import Models.Appliance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StorageDataController extends DatabaseConnection {
    public StorageDataController() throws ClassNotFoundException {
        JdbcSQLiteConnection();
    }
    public ArrayList<Appliance> getAppliance (){
        ArrayList<Appliance> appliances = new ArrayList<>();
        try{
            connect();
            String query = "Select * from appliance_storage";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                Appliance appliance = new Appliance(id, name, quantity);
                appliances.add(appliance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appliances;
    }

    public void editApplianceQuantity (int id, int newQuantity){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE appliance_storage SET quantity = "+newQuantity+" WHERE id = "+id);
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
