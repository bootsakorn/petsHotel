package Models;

import java.util.ArrayList;

public class FoodStorage implements Stockable {
    private ArrayList<Food> foods;

    public FoodStorage(){
        this.foods = new ArrayList<>();
    }

    public void insert(String name, String species, double price,int qualtity) {
        Food newItem = new Food(name,species,price,qualtity);
        foods.add(newItem);
    }

    @Override
    public void add(String name, int qualtity) {
        for (Food item:foods) {
            if (item.getName().equalsIgnoreCase(name)){
                item.setQualtity(item.getQualtity() + qualtity);
            }
        }
    }

    @Override
    public void remove(String name, int qualtity) {
        for (Food item:foods) {
            if (item.getName().equalsIgnoreCase(name)){
                item.setQualtity(item.getQualtity() - qualtity);
            }
        }
    }
}
