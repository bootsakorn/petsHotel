package Models;

public class Food {
    private String name;
    private String species;
    private double price;
    private int qualtity;

    public Food(String name, String species, double price,int qualtity){
        this.name = name;
        this.species = species;
        this.price = price;
        this.qualtity = qualtity;
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
    public int getQualtity() {
        return qualtity;
    }
    public void setQualtity(int qualtity) {
        this.qualtity = qualtity;
    }
}
