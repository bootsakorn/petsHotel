package Models;

import java.util.Date;

public class CheckOut {
    private Date date;
    private int appointment_bill_id;
    private String receiver_name;
    private int id;
    private boolean status;

    public CheckOut(int id, Date date, int appointment_bill_id, String receiver_name, boolean status){
        this.id = id;
        this.date = date;
        this.appointment_bill_id = appointment_bill_id;
        this.receiver_name = receiver_name;
        this.status = status;
    }
}
