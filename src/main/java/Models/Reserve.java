package Models;

import java.util.ArrayList;
import java.util.Date;

public class Reserve {
    private Date reserve_date;
    private Date start_date;
    private int number_of_reserve;
    private int customer_id;
    private int pets_id;
    private double pledge; //เงินค่ามัดจำ
    private double total_price;
    private int id;
    private ArrayList<TakingCarePetsList> list ;

    public Reserve(int id, Date reserve_date, Date start_date, int number_of_reserve, int customer_id, int pets_id, double pledge, double total_price){
        this.id = id;
        this.reserve_date = reserve_date;
        this.start_date = start_date;
        this.number_of_reserve = number_of_reserve;
        this.customer_id = customer_id;
        this.pets_id = pets_id;
        this.pledge = pledge;
        this.total_price = total_price;
    }

    public void setPetsList(ArrayList<TakingCarePetsList> takingCarePetsLists) {
        this.list = takingCarePetsLists;
    }

}
