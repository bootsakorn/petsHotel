package Models;

public class Food {
    private int id;
    private String name;
    private String species;
    private double price;
    private int quantity;

    public Food(int id, String name, String species, double price, int quantity){
        this.id = id;
        this.name = name;
        this.species = species;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
