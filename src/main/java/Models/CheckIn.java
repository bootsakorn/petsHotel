package Models;

import java.util.Date;

public class CheckIn {
    private Date date;
    private int reserve_id;
    private int appointment_bill_id;
    private int receipt_id;
    private int id;
    private boolean status;

    public CheckIn(int id, Date date, int reserve_id, int appointment_bill_id, int receipt_id, boolean status){

        this.id = id;
        this.date = date;
        this.reserve_id = reserve_id;
        this.appointment_bill_id = appointment_bill_id;
        this.receipt_id = receipt_id;
        this.status = status;
    }
}
