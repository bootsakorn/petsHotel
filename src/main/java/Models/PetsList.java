package Models;

public class PetsList {
    private int customerId;
    private int petId;

    public PetsList (int customerId, int petsId){
        this.customerId = customerId;
        this.petId = petsId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPetId() {
        return petId;
    }
}
