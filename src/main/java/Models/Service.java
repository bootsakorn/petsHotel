package Models;

public class Service {
    private int id;
    private String petName;
    private int room;
    private String detail;
    private boolean status;
    private String date;

    public Service (int id, String petName, int room, String detail, boolean status, String date){
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

    public int getRoom() {
        return room;
    }

    public String getDetail() {
        return detail;
    }

    public boolean getStatus() {
        return status;
    }
}
