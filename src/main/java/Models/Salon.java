package Models;

public class Salon {
    private int id;
    private String petName;
    private String room;
    private String detail;
    private boolean status;
    private String date;

    public Salon (int id, String petName, String room, String detail, boolean status, String date){
        this.id = id;
        this.petName = petName;
        this.detail = detail;
        this.room = room;
        this.status = status;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getPetName() {
        return petName;
    }

    public String getRoom() {
        return room;
    }

    public String getDetail() {
        return detail;
    }

    public boolean getStatus() {
        return status;
    }
}
