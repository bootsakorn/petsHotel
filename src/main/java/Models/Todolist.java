package Models;

import java.util.Date;

public class Todolist {
    private Date date;
    private int food_id;
    private int package_id;
    private int status;
    private String note;

    public Todolist(Date date, int food_id, int package_id, int status, String note){
        this.date = date;
        this.food_id = food_id;
        this.package_id = package_id;
        this.status = status;
        this.note = note;
    }

    public void updateStatus(){
        this.status = 1;
    }
}
