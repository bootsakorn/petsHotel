package Controller.dataController;

import Models.Food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodDataController extends DatabaseConnection{
    public FoodDataController() {
        JdbcSQLiteConnection();
    }

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
                int quantity = resultSet.getInt("quantity");
                Food food = new Food(id, name, species, price, quantity);
                foods.add(food);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }


    public void insertFood (String name , String species, double price, int quantity){
        try {
            connect();
            String query = "INSERT INTO food (name,species_id,price,quantity) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, speciesDataController.convertSpeciesNameToId(species));
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editFoodQuantity (int id, int newQuantity){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE food SET quantity = "+newQuantity+" WHERE id = "+id);
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
