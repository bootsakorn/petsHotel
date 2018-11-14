package Models;

import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private ArrayList<Pets> pets;

    public Customer(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = new ArrayList<>();
    }

    public void addPets(Pets newPets){
        this.pets.add(newPets);
    }


}
