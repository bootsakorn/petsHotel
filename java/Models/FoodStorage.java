package Models;

import java.util.ArrayList;

public class FoodStorage implements Stockable {
    private ArrayList<Food> foods;

    public FoodStorage(){
        this.foods = new ArrayList<>();
    }

    public void setFoods(ArrayList<Food> foods) {
        foods = foods;
    }

    @Override
    public void add(Object o, int quantity) {
         for (int i=0; i<foods.size(); i++){
             if (foods.get(i).getId()==((Food) o).getId()){
                 foods.get(i).setQuantity(foods.get(i).getQuantity() + quantity);
             }
         }
    }

    @Override
    public void remove(Object o, int qualtity) {
        this.add(o, qualtity*-1);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}
