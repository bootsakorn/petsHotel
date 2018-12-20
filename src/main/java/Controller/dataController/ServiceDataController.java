package Controller.dataController;

import Models.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceDataController extends DatabaseConnection {
    public ServiceDataController() {
        JdbcSQLiteConnection();
    }
    public ArrayList<Service> getServices (){
        ArrayList<Service> services = new ArrayList<>();
        try {
            connect();
            String query = "Select * from service";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String petName = resultSet.getString("pet");
                String room = resultSet.getString("room");
                int statusInt = resultSet.getInt("status");
                String detail = resultSet.getString("detail");
                String date = resultSet.getString("date");
                boolean status;
                if (statusInt == 1) {
                    status = true;
                } else {
                    status = false;
                }
                Service salon = new Service(id, petName, room, detail, status, date);
                services.add(salon);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public void insertService(String petName, String room, int status, String detail, String date){
        try{
            connect();
            String query = "INSERT INTO todolist (pet, room, status, detail, date) VALUSE (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, petName);
            stmt.setString(2, room);
            stmt.setInt(3, status);
            stmt.setString(4, detail);
            stmt.setString(5, date);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editStatus (int serviceId, int newStatus){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE service SET status = "+newStatus+" WHERE id = '"+serviceId+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
