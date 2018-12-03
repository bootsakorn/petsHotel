package Controller.dataController;

import Models.PetsList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PetsListDataController extends DatabaseConnection{
    public ArrayList<PetsList> getPetsIdList() {
        ArrayList<PetsList> petsIdList = new ArrayList<>();
        try{
            connect();
            String query = "Select * from pets_list";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                int petId = resultSet.getInt("pet_id");
                PetsList petsList = new PetsList(customerId, petId);
                petsIdList.add(petsList);
            }
            disconnect();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return petsIdList;
    }
}
