package Controller.dataController;

import Models.Package;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PackageDataController extends DatabaseConnection {
    public PackageDataController() {
        JdbcSQLiteConnection();
    }
    public ArrayList<Package> getPackage (){
        ArrayList<Package> packages = new ArrayList<>();
        try {
            connect();
            String query = "Select * from packages";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int shower = resultSet.getInt("shower");
                int salon = resultSet.getInt("salon");
                int swim = resultSet.getInt("swim");
                int walk = resultSet.getInt("walk");
                double price = resultSet.getDouble("price");
                Package packge = new Package(id, name, price, shower, salon, swim, walk);
                packages.add(packge);
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }
}
