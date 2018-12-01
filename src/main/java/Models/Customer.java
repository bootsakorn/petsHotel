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

}
