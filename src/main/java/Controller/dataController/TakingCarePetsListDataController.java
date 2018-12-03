package Controller.dataController;

import Models.TakingCarePetsList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TakingCarePetsListDataController extends DatabaseConnection {
    public ArrayList<TakingCarePetsList> getTakingCarePetsList (){
        ArrayList<TakingCarePetsList> takingCarePetsLists = new ArrayList<>();
        try {
            connect();
            String query = "Select * from taking_care_pets_list";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                int petId = resultSet.getInt("pet_id");
                int foodId = resultSet.getInt("food_id");
                int packageId = resultSet.getInt("package_id");
                int roomId = resultSet.getInt("room_id");
                TakingCarePetsList takingCarePetsList = new TakingCarePetsList(id, customerId, petId, foodId, packageId, roomId);
                takingCarePetsLists.add(takingCarePetsList);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return takingCarePetsLists;
    }

    public ArrayList<TakingCarePetsList> getTakingCarePetsList (int customerId) {
        ArrayList<TakingCarePetsList> takingCarePetsLists = new ArrayList<>();
        try {
            connect();
            String query = "Select * from taking_care_pets_list where customer_id = '"+customerId+"'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int petId = resultSet.getInt("pet_id");
                int foodId = resultSet.getInt("food_id");
                int packageId = resultSet.getInt("package_id");
                int roomId = resultSet.getInt("room_id");
                TakingCarePetsList takingCarePetsList = new TakingCarePetsList(id, customerId, petId, foodId, packageId, roomId);
                takingCarePetsLists.add(takingCarePetsList);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return takingCarePetsLists;
    }

    public void insertTakingCarePetsList (int id, int customerId, int petId, int packageId, int foodId, int roomId){
        try {
            connect();
            String query = "INSERT INTO taking_care_pets_list (id, customer_id, pet_id, package_id, food_id, room_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setInt(2, customerId);
            stmt.setInt(3, petId);
            stmt.setInt(4, packageId);
            stmt.setInt(5, foodId);
            stmt.setInt(6, roomId);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getMaxId(){
        int max_id = 0;
        try {
            connect();
            String query = "Select MAX(id) AS max_id from taking_care_pets_list";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                max_id = resultSet.getInt("max_id");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max_id;
    }
}
