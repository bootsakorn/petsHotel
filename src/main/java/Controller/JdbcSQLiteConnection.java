package Controller;

import java.sql.*;

public class JdbcSQLiteConnection {
    private Connection conn;
    private final String DBURL = "jdbc:sqlite:petshotel.db";
    public void JdbcSQLiteConnection () throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
    }
    private void connect() throws SQLException {
        conn = DriverManager.getConnection(DBURL);
    }

    private void disconnect() throws SQLException {
        if (conn != null) {
            conn.close();
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
