package Models;

public class TakingCarePetsList {
    int id;
    int petId;
    int foodId;
    int packageId;
    int roomId;

    public TakingCarePetsList (int id, int petId, int foodId, int packageId, int roomId){
        this.id = id;
        this.foodId = foodId;
        this.petId = petId;
        this.packageId = packageId;
        this.roomId = roomId;
    }
}
