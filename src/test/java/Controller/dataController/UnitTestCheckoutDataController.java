package Controller.dataController;

import Models.CheckOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class UnitTestCheckoutDataController {
    private CheckoutDataController cdc;
    private DataController dc;
    private ArrayList<CheckOut> list;

    @BeforeEach
    void setup(){
        try {
            dc = new DataController();
            cdc = new CheckoutDataController();
            list = dc.getCheckOuts();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateStatusTest(){
        boolean oldStatus = list.get(list.size()-1).isStatus();
        if (!oldStatus){
            cdc.editStatus(list.get(list.size()-1).getId(), 1);
        }else {
            cdc.editStatus(list.get(list.size()-1).getId(), 0);
        }
        dc.getData();
        list = dc.getCheckOuts();
        boolean newStatus = list.get(list.size()-1).isStatus();
        if (newStatus){
            cdc.editStatus(list.get(list.size()-1).getId(), 0);
        }else {
            cdc.editStatus(list.get(list.size()-1).getId(), 1);
        }
        assertEquals(true, oldStatus ^ newStatus);

    }
}