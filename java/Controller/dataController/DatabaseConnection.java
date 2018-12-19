package Controller.dataController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected Connection conn;
    protected final String DBURL = "jdbc:sqlite:petshotel.db";
    public void JdbcSQLiteConnection () {
        try{
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    protected void connect() throws SQLException {
        conn = DriverManager.getConnection(DBURL);
    }

    protected void disconnect() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
