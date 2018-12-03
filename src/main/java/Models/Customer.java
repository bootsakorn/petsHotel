package Models;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private ArrayList<Pets> pets;

    public Customer(int id, String firstName, String lastName, String address){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.pets = new ArrayList<>();
    }

    public void addPets(Pets newPets){
        this.pets.add(newPets);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public ArrayList<Pets> getPets() {
        return pets;
    }

}
