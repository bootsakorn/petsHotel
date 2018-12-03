package Controller.dataController;

import Models.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RoomDataController extends DatabaseConnection {
    public RoomDataController() {
        JdbcSQLiteConnection();
    }
    public ArrayList<Room> getRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        try{
            connect();
            String query = "Select * from rooms";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                int typeId = resultSet.getInt("type_id");
                int speciesId = resultSet.getInt("species_id");
                double price = resultSet.getDouble("price");
                int status = resultSet.getInt("status");
                Room room = new Room(id, name, number, typeId, speciesId,price, status);
                rooms.add(room);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public void editStatus(int roomId, int newStatus) {
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE room SET status = "+newStatus+" WHERE id = '"+roomId+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
