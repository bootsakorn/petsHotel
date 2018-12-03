package Models;

import java.util.Date;

public class CheckOut {
    private Date date;
    private int appointment_bill_id;
    private int receiver_name;
    private int id;

    public CheckOut(int id, Date date, int appointment_bill_id, int receiver_name){
        this.id = id;
        this.date = date;
        this.appointment_bill_id = appointment_bill_id;
        this.receiver_name = receiver_name;
    }
}
