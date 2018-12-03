package Controller.dataController;

import Models.Food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodDataController extends DatabaseConnection{
    private SpeciesDataController speciesDataController = new SpeciesDataController();
    public ArrayList<Food> getFoods () {
        ArrayList<Food> foods = new ArrayList<>();
        try {
            connect();
            String query = "Select * from food";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("firstname");
                String species = speciesDataController.convertSpeciesIdToName(resultSet.getInt("species_id"));
                double price = resultSet.getDouble("price");
                Food food = new Food(id, name, species, price);
                food.setPrice(getQuantity(id));
                foods.add(food);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public int getQuantity (int id){
        int quantity = 0;
        try {
            connect();
            String query = "Select * from food_storage where food_id = '"+id+"'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                quantity = resultSet.getInt("quantity");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }

    public void insertFood (String name , String species, double price){
        try {
            connect();
            String query = "INSERT INTO food (name,species_id,price) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, speciesDataController.convertSpeciesNameToId(species));
            stmt.setDouble(3, price);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setFoodQuantity (Food food, int newQuantity){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE food_storage SET quantity = "+newQuantity+" WHERE food_id = '"+food.getId()+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
