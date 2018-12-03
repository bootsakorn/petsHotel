package Models;

import java.util.Date;

public class AppointmentBill {
    private int id;
    private Date appointmentDate;
    private int takingCarePetsListId;

    public AppointmentBill(int id, Date appointmentDate, int takingCarePetsListId) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.takingCarePetsListId = takingCarePetsListId;
    }

    public int getId() {
        return id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public int getTakingCarePetsListId() {
        return takingCarePetsListId;
    }
}
