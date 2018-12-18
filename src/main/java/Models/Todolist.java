package Models;

import java.util.Date;

public class Todolist {
    private int id;
    private Date date;
    private int food_id;
    private int package_id;
    private boolean status;
    private String note;

    public Todolist(int id, Date date, int food_id, int package_id, boolean status, String note){
        this.id = id;
        this.date = date;
        this.food_id = food_id;
        this.package_id = package_id;
        this.status = status;
        this.note = note;
    }

    public void updateStatus(){
        this.status = true;
    }
}
