package Models;

import java.util.Date;

public class AppointmentBill {
    private int id;
    private Date appointmentDate;
    private int takingCarePetsListId;
    private double pledge;

    public AppointmentBill(int id, Date appointmentDate, int takingCarePetsListId, double pledge) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.takingCarePetsListId = takingCarePetsListId;
        this.pledge = pledge;
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

    public double getPledge() {
        return pledge;
    }
}
