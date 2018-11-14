package Models;

import java.util.Date;

public class CheckOut {
    private Date date;
    private int appointment_bill_id;
    private int receiver_name;

    public CheckOut(Date date, int appointment_bill_id, int receiver_name){
        this.date = date;
        this.appointment_bill_id = appointment_bill_id;
        this.receiver_name = receiver_name;
    }
}
