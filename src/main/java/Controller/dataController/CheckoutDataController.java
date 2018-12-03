package Controller.dataController;

import Models.CheckOut;

import java.util.ArrayList;

public class CheckoutDataController extends DatabaseConnection{
    public ArrayList<CheckOut> getCheckoutArrayList (){
        ArrayList<CheckOut> checkOutsArrayList = new ArrayList<>();
        return checkOutsArrayList;
    }
}
