package Models;

import java.util.Date;

public class Receipt {
    private int id;
    private Date date;
    private int checkIn_id;
    private double total_price;
    private double recieve;
    private double change;

    public Receipt(int id, Date date, int checkIn_id, double total_price, double recieve, double change){
        this.id = id;
        this.date = date;
        this.checkIn_id = checkIn_id;
        this.total_price = total_price;
        this.recieve = recieve;
        this.change = change;
    }
}
