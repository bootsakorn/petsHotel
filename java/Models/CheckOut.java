package Models;

import java.util.Date;

public class CheckOut {
    private String date;
    private int appointment_bill_id;
    private String receiver_name;
    private int id;
    private boolean status;

    public CheckOut(int id, String date, int appointment_bill_id, String receiver_name, boolean status){
        this.id = id;
        this.date = date;
        this.appointment_bill_id = appointment_bill_id;
        this.receiver_name = receiver_name;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public int getAppointment_bill_id() {
        return appointment_bill_id;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }
}
