package Models;

import java.util.ArrayList;

public class PetsList {
    private int customerId;
    private int petsListId;

    public PetsList (int customerId, int petsListId){
        this.customerId = customerId;
        this.petsListId = petsListId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPetsListId() {
        return petsListId;
    }
}
