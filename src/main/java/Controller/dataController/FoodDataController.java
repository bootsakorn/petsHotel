package Controller.dataController;

import Models.Food;

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
                int id = resultSet.getInt("ig");
                String name = resultSet.getString("firstname");
                String species = speciesDataController.convertSpeciesIdToName(resultSet.getInt("species_id"));
                double price = resultSet.getDouble("price");
                Food food = new Food(id, name, species, price);
                food.setPrice(getQualtity(id));
                foods.add(food);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public int getQualtity (int id){
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
}
