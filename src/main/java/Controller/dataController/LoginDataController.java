package Controller.dataController;

import java.sql.*;
import java.util.ArrayList;

public class LoginDataController extends DatabaseConnection {

    public ArrayList<String> getUsernames () {
        ArrayList<String> usernames = new ArrayList<>();
        try {
            connect();
            String query = "Select username from employees";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                usernames.add(username);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usernames;
    }

    public String getPassword (String username) {
        String password = "";
        try {
            connect();
            String query = "select password from employees where username='"+username+"'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                password = resultSet.getString("username");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    public void editPassword(int id, String newPassword){
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE employees SET password = '"+newPassword+"' WHERE id = '"+id+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public void getData() {
        try {
            connect();
            String query = "Select * from pets";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.println("id:"+id+" name:"+name+" age: "+age);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertTransaction() {
        try {
            connect();
            String name = "มโหรี";
            int age = 10;
            String sex = "เพศเมีย";
            String breed = "ชิสุ";
            String disease = "";
            String allergy = "";
            int species_id = 1;
            String query = "INSERT INTO pets (name,age,sex,breed,disease,allergy,species_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, sex);
            stmt.setString(4, breed);
            stmt.setString(2, disease);
            stmt.setString(3, allergy);
            stmt.setInt(4, species_id);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editPetName(String name ,int id){
//        UPDATE `transaction` SET `id`=[value-1],`detail`=[value-2],`type`=[value-3],`amount`=[value-4],`date`=[value-5] WHERE 1
        try {
            connect();
            Statement stmt = conn.createStatement();
            String query = ("UPDATE pets SET name = '"+name+"' WHERE id = '"+id+"'");
            stmt.execute(query);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteById(int id){
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
