package Models;

import java.util.ArrayList;

public class FoodStorage implements Stockable {
    private ArrayList<Food> foods;

    public FoodStorage(){
        this.foods = new ArrayList<>();
    }

    @Override
    public void insert(String name, int qualtity) {

    }

    @Override
    public void add(String name, int qualtity) {

    }

    @Override
    public void remove(String name, int qualtity) {

    }
}
