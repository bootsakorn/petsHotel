package Controller.dataController;

import Models.CheckIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class UnitTestCheckInDataController {
    private CheckInDataController cdc;
    private DataController dc;
    private ArrayList<CheckIn> list;

    @BeforeEach
    void setup(){
        try {
            dc = new DataController();
            cdc = new CheckInDataController();
            list = dc.getCheckIns();
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
        list = dc.getCheckIns();
        boolean newStatus = list.get(list.size()-1).isStatus();
        if (newStatus){
            cdc.editStatus(list.get(list.size()-1).getId(), 0);
        }else {
            cdc.editStatus(list.get(list.size()-1).getId(), 1);
        }
        assertEquals(true, oldStatus ^ newStatus);
    }

}