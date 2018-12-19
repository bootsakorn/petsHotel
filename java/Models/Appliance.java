package Models;

public class Appliance {
    private String name;
    private int quantity;
    private int id;

    public Appliance(int id, String name, int quantity){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getId() {
        return this.id;
    }
}
