package Models;

import java.util.Date;

public class AppointmentBill {
    private int id;
    private String appointmentDate;
    private int takingCarePetsListId;

    public AppointmentBill(int id, String appointmentDate, int takingCarePetsListId) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.takingCarePetsListId = takingCarePetsListId;
    }

    public int getId() {
        return id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public int getTakingCarePetsListId() {
        return takingCarePetsListId;
    }
}
