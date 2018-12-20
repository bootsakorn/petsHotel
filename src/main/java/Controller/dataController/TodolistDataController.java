package Controller.dataController;

import Models.Todolist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TodolistDataController extends DatabaseConnection{
    public TodolistDataController() {
        JdbcSQLiteConnection();
    }
    public ArrayList<Todolist> getTodoLists (){
        ArrayList<Todolist> todolists = new ArrayList<>();
        try {
            connect();
            String query = "Select * from todolist";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String dateStr = resultSet.getString("date");
                Date date = format.parse(dateStr);
                int foodId = resultSet.getInt("food_id");
                int packageId = resultSet.getInt("package_id");
                int statusInt = resultSet.getInt("status");
                String note = resultSet.getString("note");
                int tkcId = resultSet.getInt("taking_care_id");
                boolean status;
                if (statusInt == 1) {
                    status = true;
                } else {
                    status = false;
                }
                Todolist todolist = new Todolist(id, date, foodId, packageId, status, note, tkcId);
                todolists.add(todolist);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return todolists;
    }

    public void insertTodolist(String date, int foodId, int packageId, int status, String note, int tkc_id){
        try{
            connect();
            String query = "INSERT INTO todolist (date, food_id, package _id, status, note, taking_care_id) VALUSE (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, date);
            stmt.setInt(2, foodId);
            stmt.setInt(3, packageId);
            stmt.setInt(4, status);
            stmt.setString(5, note);
            stmt.setInt(6, tkc_id);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editStatus (int todolistId, int newStatus){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE todolist SET status = "+newStatus+" WHERE id = '"+todolistId+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
