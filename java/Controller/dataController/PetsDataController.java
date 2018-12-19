package Controller.dataController;

import Models.Pets;

import java.sql.*;
import java.util.ArrayList;

public class PetsDataController extends DatabaseConnection{
    public PetsDataController() {
        JdbcSQLiteConnection();
    }
    private SpeciesDataController speciesDataController = new SpeciesDataController();
    public ArrayList<Pets> getPetsList (){
        ArrayList<Pets> petsList = new ArrayList<>();
        try {
            connect();
            String query = "Select * from pets";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int age = resultSet.getInt("age");
                String breed = resultSet.getString("breed");
                String disease = resultSet.getString("disease");
                String allergy = resultSet.getString("allergy");
                int species_id = resultSet.getInt("species_id");
                String species = speciesDataController.convertSpeciesIdToName(species_id);
                Pets pet = new Pets(id, name, sex, age, breed, disease, allergy, species);
                petsList.add(pet);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petsList;
    }

    public void insertPet(String name, int age, String sex, String breed, String disease, String allergy, int species) {
        try {
            connect();
            String query = "INSERT INTO pets (name,age,sex,breed,disease,allergy,species_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, sex);
            stmt.setString(4, breed);
            stmt.setString(5, disease);
            stmt.setString(6, allergy);
            stmt.setInt(7, species);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editPet(int id, Pets pet){
//        UPDATE `transaction` SET `id`=[value-1],`detail`=[value-2],`type`=[value-3],`amount`=[value-4],`date`=[value-5] WHERE 1
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE pets SET name = '"+pet.getName()+"',age = "+pet.getAge()+",sex = '"+pet.getSex()+"',breed = '"+pet.getBreed()+"',disease = '"+pet.getDisease()+"',allergy = '"+pet.getAllergy()+"',species_id = '"+speciesDataController.convertSpeciesNameToId(pet.getSpecies())+"' WHERE id = '"+id+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deletePet(int id){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("DELETE FROM pets WHERE id = '"+id+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

