package Models;

import java.util.ArrayList;

public class ApplianceStorage implements Stockable {
    private ArrayList<Appliance> appliances;

    public ApplianceStorage(){
        this.appliances = new ArrayList<>();
    }

    public void insert(Appliance appliance) {
        this.appliances.add(appliance);
    }

    public void setAppliances(ArrayList<Appliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void add(Object o, int quantity) {
        for (int i=0; i<appliances.size(); i++){
            if (appliances.get(i).getId() == ((Appliance) o).getId()){
                appliances.get(i).setQuantity(appliances.get(i).getQuantity() + quantity);
            }
        }
    }

    @Override
    public void remove(Object o, int quantity) {
        this.add(o, quantity);
    }

    public ArrayList<Appliance> getAppliances() {
        return appliances;
    }
}
