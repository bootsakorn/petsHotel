package Models;

import java.util.ArrayList;

public class FoodStorage implements Stockable {
    private ArrayList<Food> foods;

    public FoodStorage(){
        this.foods = new ArrayList<>();
    }

    public void insert(String name, String species, double price,int qualtity) {
        Food newItem = new Food(1,"วิสกี้","แมว",300);
        foods.add(newItem);
    }

    @Override
    public void add(String name, int qualtity) {
        for (Food item:foods) {
            if (item.getName().equalsIgnoreCase(name)){
                item.setQuantity(item.getQuantity() + qualtity);
            }
        }
    }

    @Override
    public void remove(String name, int qualtity) {
        for (Food item:foods) {
            if (item.getName().equalsIgnoreCase(name)){
                item.setQuantity(item.getQuantity() - qualtity);
            }
        }
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}
