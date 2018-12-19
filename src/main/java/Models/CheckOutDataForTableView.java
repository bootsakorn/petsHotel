package Models;

public class CheckOutDataForTableView {
    private int id;
    private String date;
    private String firstName;
    private String petName;

    public CheckOutDataForTableView(int id , String date, String firstName, String petName){
        this.id = id;
        this.date = date;
        this.firstName = firstName;
        this.petName = petName;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPetName() {
        return petName;
    }
}
