package Models;

import java.util.ArrayList;

public class ApplianceStorage implements Stockable {
    private ArrayList<Appliance> appliances;

    public ApplianceStorage(){
        this.appliances = new ArrayList<>();
    }

    public void insert(int id, String name, int qualtity) {
        Appliance newItem = new Appliance(id, name, qualtity);
        this.appliances.add(newItem);
    }

    @Override
    public void add(String name, int qualtity) {
        for (Appliance item:appliances) {
            if (item.getName().equalsIgnoreCase(name)){
                item.setQualtity(item.getQualtity() + qualtity);
            }
        }
    }

    @Override
    public void remove(String name, int qualtity) {
        for (Appliance item:appliances) {
            if (item.getName().equalsIgnoreCase(name)){
                item.setQualtity(item.getQualtity() - qualtity);
            }
        }
    }

    public ArrayList<Appliance> getAppliances() {
        return appliances;
    }
}
