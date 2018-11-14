package Models;

import java.util.Date;

public class Receipt {
    private Date date;
    private int checkIn_id;
    private double total_price;
    private double recieve;
    private double change;

    public Receipt(Date date, int checkIn_id, double total_price, double recieve, double change){
        this.date = date;
        this.checkIn_id = checkIn_id;
        this.total_price = total_price;
        this.recieve = recieve;
        this.change = change;
    }
}
