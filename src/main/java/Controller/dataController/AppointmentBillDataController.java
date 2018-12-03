package Controller.dataController;

import Models.AppointmentBill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentBillDataController extends DatabaseConnection {
    public ArrayList<AppointmentBill> getAppointmentBills() {
        ArrayList<AppointmentBill> appointmentBills = new ArrayList<>();
        try {
            connect();
            String query = "Select * from appointment_bill";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String date_str = resultSet.getString("appointment_date");
                Date appointmentDate = format.parse(date_str);
                int takingCarePetsId = resultSet.getInt("taking_care_pets_id");
                double pledge = resultSet.getDouble("pledge");
                AppointmentBill appointmentBill = new AppointmentBill(id, appointmentDate, takingCarePetsId, pledge);
                appointmentBills.add(appointmentBill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return appointmentBills;
    }

    public void insertAppointmentBill (String appointmentDate, int takingCarePetsId, double pledge) {
        try {
            connect();
            String query = "INSERT INTO appointment_bill(appointment_date, taking_care_pets_id, pledge)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, appointmentDate);
            stmt.setInt(2, takingCarePetsId);
            stmt.setDouble(3, pledge);
            stmt.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
