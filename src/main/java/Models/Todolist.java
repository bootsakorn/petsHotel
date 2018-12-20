package Models;

import java.util.Date;

public class Todolist {
    private int id;
    private Date date;
    private int food_id;
    private int package_id;
    private boolean status;
    private String note;
    private int tkc_id;

    public Todolist(int id, Date date, int food_id, int package_id, boolean status, String note, int tkc_id){
        this.id = id;
        this.date = date;
        this.food_id = food_id;
        this.package_id = package_id;
        this.status = status;
        this.note = note;
        this.tkc_id = tkc_id;
    }

    public void updateStatus(){
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getFood_id() {
        return food_id;
    }

    public int getPackage_id() {
        return package_id;
    }

    public boolean isStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public int getTkc_id() {
        return tkc_id;
    }
}
