package Models;

public class Appliance {
    private String name;
    private int qualtity;
    private int id;

    public Appliance(int id, String name, int qualtity){
        this.id = id;
        this.name = name;
        this.qualtity = qualtity;
    }

    public String getName() {
        return name;
    }
    public int getQualtity() {
        return qualtity;
    }
    public void setQualtity(int qualtity) {
        this.qualtity = qualtity;
    }
}
