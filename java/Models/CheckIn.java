package Models;

import java.util.Date;

public class CheckIn {
    private String date;
    private int reserve_id;
    private int appointment_bill_id;
    private int receipt_id;
    private int id;
    private boolean status;

    public CheckIn(int id, String date, int reserve_id, int appointment_bill_id, int receipt_id, boolean status){

        this.id = id;
        this.date = date;
        this.reserve_id = reserve_id;
        this.appointment_bill_id = appointment_bill_id;
        this.receipt_id = receipt_id;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public int getReserve_id() {
        return reserve_id;
    }

    public int getAppointment_bill_id() {
        return appointment_bill_id;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }
}
