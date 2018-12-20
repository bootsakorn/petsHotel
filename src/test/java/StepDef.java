import Controller.dataController.CheckoutDataController;
import Controller.dataController.DataController;
import Models.CheckOut;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class StepDef {
    private CheckoutDataController cdc;
    private DataController dc;
    private ArrayList<CheckOut> list;
    private CheckOut checkOut;

    @Before
    public void setup() {
        try {
            dc = new DataController();
            cdc = new CheckoutDataController();
            list = dc.getCheckOuts();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Given("a customer (.*) check out with appointment number (\\d+)")
    public void givenCheckout(String name, int id) {
        for (CheckOut checkOut:list){
            if (checkOut.getAppointment_bill_id() == id){
                this.checkOut = checkOut;
            }
        }
    }
    @When("I click appointment number (\\d+) and I check out")
    public void whenCheckOut(int id){

    }
    @Then("system edit status in checkout number (\\d+) to (.*)")
    public void thenCheckOut(int id, String bl){
        cdc.editStatus(id,1);
        dc.getData();
        list = dc.getCheckOuts();
        boolean status = true;
        for (CheckOut checkOut:list){
            if (checkOut.getId() == id){
               status = checkOut.isStatus();
            }
        }
        cdc.editStatus(id,0);
        assertEquals(Boolean.valueOf(bl), status);
    }
}
