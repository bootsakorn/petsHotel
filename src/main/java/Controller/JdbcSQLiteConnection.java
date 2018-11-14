package Controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcSQLiteConnection {
    public static void main(String[] args) {
        try {
// setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:petshotel.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
// display database information
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Product name: " + dm.getDatabaseProductName());
// execute SQL statements
                String query = "Select * from pets";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int age = resultSet.getInt(3);

                    System.out.println("id:"+id+" name:"+name+" age: "+age);
                }
// close connection
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
