package Models;

public class TakingCarePetsList {
    private int id;
    private int petId;
    private int foodId;
    private int packageId;
    private int roomId;

    public TakingCarePetsList (int id, int petId, int foodId, int packageId, int roomId){
        this.id = id;
        this.foodId = foodId;
        this.petId = petId;
        this.packageId = packageId;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public int getFoodId() {
        return foodId;
    }

    public int getPackageId() {
        return packageId;
    }

    public int getRoomId() {
        return roomId;
    }
}
