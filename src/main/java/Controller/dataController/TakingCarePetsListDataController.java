package Controller.dataController;

import Models.TakingCarePetsList;

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
                int petId = resultSet.getInt("pet_id");
                int foodId = resultSet.getInt("food_id");
                int packageId = resultSet.getInt("package_id");
                int roomId = resultSet.getInt("room_id");
                TakingCarePetsList takingCarePetsList = new TakingCarePetsList(id, petId, foodId, packageId, roomId);
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
                TakingCarePetsList takingCarePetsList = new TakingCarePetsList(id, petId, foodId, packageId, roomId);
                takingCarePetsLists.add(takingCarePetsList);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return takingCarePetsLists;
    }
}
