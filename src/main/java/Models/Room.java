package Models;

public class Room {
    private String name;
    private int number;
    private String[] type_list = {"ห้องเดี่ยว", "ห้องรวม"};
    private String[] species_list = {"สุนัข", "แมว", "กระต่าย"};
    private String type;
    private String species;
    private double price;
    private int id;
    private int status;

    public Room(int id, String name, int number, int type, int species, double price, int status){
        this.id = id;
        this.status = status;
        this.name = name;
        this.number = number;
        this.type = this.type_list[type];
        this.species = this.species_list[species];
        this.price = price;
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
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }
}
