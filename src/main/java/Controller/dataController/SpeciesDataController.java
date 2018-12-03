package Controller.dataController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SpeciesDataController extends DatabaseConnection {
    public ArrayList<String> getSpecies () {
        ArrayList<String> species = new ArrayList<>();
        try {
            connect();
            String query = "Select name from species_list";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String species_name = resultSet.getString("name");
                species.add(species_name);
            }
            disconnect();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return species;
    }
    public String convertSpeciesIdToName (int species_id) {
        String species = "";
        try {
            connect();
            String query = "Select name from species_list where id='"+species_id+"'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                species = resultSet.getString("name");
            }
            disconnect();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return species;
    }

    public int convertSpeciesNameToId (String species) {
        int species_id = 0;
        try {
            connect();
            String query = "Select id from species_list where name='"+species+"'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                species_id = resultSet.getInt("id");
            }
            disconnect();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return species_id;
    }
}
