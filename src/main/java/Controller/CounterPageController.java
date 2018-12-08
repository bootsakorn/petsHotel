package Controller;

import Controller.dataController.DataController;
import Models.Customer;
import Models.FoodStorage;
import Models.Pets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class CounterPageController extends PageSwitchController{
    @FXML protected MenuItem home;
    @FXML protected MenuItem calendar;
    @FXML protected MenuItem logout;
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;
    @FXML protected Button addBtn;
    @FXML protected Button reserveBtn;
    @FXML protected Button searchBtn;
    @FXML protected ListView customerList;
    @FXML protected Button checkInPageBtn;
    @FXML protected Button checkOutPageBtn;
    @FXML protected Button roomBtn;
    @FXML private Parent root ;

    private Customer cus;
    private FoodStorage fs = new FoodStorage();
    private DataController dataController;
    private ArrayList<Customer> customers;

    public CounterPageController(){
        try {
            dataController = new DataController();
            customers = dataController.getCustomer();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize(){
        fs.add("วิสกัส",100);
        fs.add("เพ็ดดีกรี",100);
        ObservableList<String> cusL = customerList.getItems();
        for (Customer c:customers) {
            cusL.add(c.getId() + "\t" + c.getFirstName() + " " + c.getLastName());
        }
        customerList.setItems(cusL);
        customerList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    //Button on center
    @FXML protected void handleOnClickSearchTextfield(ActionEvent e){

    }
    @FXML protected void handleOnClickAddBtn(ActionEvent event) throws Exception{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddCustomerPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }
    @FXML protected void handleOnClickReserveBtn(ActionEvent e) throws Exception{
        if (!customerList.getSelectionModel().getSelectedItems().isEmpty()){

            Button button = (Button) e.getSource();
            Stage stage = (Stage) button.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReservedPage.fxml"));
            stage.setScene(new Scene((Parent) loader.load()));

            String[] c = customerList.getSelectionModel().getSelectedItems().get(0).toString().split(" ");
            String[] c2 = c[0].split("\t");
            ReservedController rc = loader.getController();
            for (Customer cus:customers) {
                if (cus.getFirstName().equalsIgnoreCase(c2[1])){
                    rc.setCustomer(cus);
                }
            }

            stage.show();
        }

    }

    public void handleOnClickedReservationBtn(ActionEvent event) throws Exception{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CounterPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }

    public void handleOnClickedCheckOutPageBtn(ActionEvent event) throws Exception{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CheckOutPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }

    public void handleOnClickedCheckInPageBtn(ActionEvent event) throws Exception{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CheckInPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }

    public void handleOnClickedRoomBtn(ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RoomPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }

    public void handleOnClickedSearchBtn(ActionEvent event) throws Exception{
    }
}
