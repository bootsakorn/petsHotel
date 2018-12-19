package Models;

public class CheckInDataForTableView {
    private int id;
    private String startDate;
    private String firstName;

    public CheckInDataForTableView(int id , String startDate, String firstName){
        this.id = id;
        this.startDate = startDate;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFirstName() {
        return firstName;
    }
}
