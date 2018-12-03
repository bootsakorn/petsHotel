package Models;

import java.util.ArrayList;
import java.util.Date;

public class Reserve {
    private Date reserve_date;
    private Date start_date;
    private int number_of_reserve;
    private int customer_id;
    private int pets_id;
    private double total_price;
    private int id;
    private ArrayList<TakingCarePetsList> list ;

    public Reserve(int id, Date reserve_date, Date start_date, int number_of_reserve, int customer_id, int pets_id){
        this.id = id;
        this.reserve_date = reserve_date;
        this.start_date = start_date;
        this.number_of_reserve = number_of_reserve;
        this.customer_id = customer_id;
        this.pets_id = pets_id;
        this.total_price = 0;
    }

    public void setPetsList(ArrayList<TakingCarePetsList> takingCarePetsLists) {
        this.list = takingCarePetsLists;
    }

    public Date getReserve_date() {
        return reserve_date;
    }

    public void setReserve_date(Date reserve_date) {
        this.reserve_date = reserve_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public int getNumber_of_reserve() {
        return number_of_reserve;
    }

    public void setNumber_of_reserve(int number_of_reserve) {
        this.number_of_reserve = number_of_reserve;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getPets_id() {
        return pets_id;
    }

    public void setPets_id(int pets_id) {
        this.pets_id = pets_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TakingCarePetsList> getList() {
        return list;
    }

    public void setList(ArrayList<TakingCarePetsList> list) {
        this.list = list;
    }
}
