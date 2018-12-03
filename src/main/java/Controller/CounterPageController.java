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

    private ArrayList<Customer> cusList = new ArrayList<>();
    private Customer cus;
    private FoodStorage fs = new FoodStorage();
    private DataController dataController = new DataController();
    private ArrayList<Customer> customers = dataController.getCustomer();

    @FXML private void initialize(){
        fs.add("วิสกัส",100);
        fs.add("เพ็ดดีกรี",100);
        cus = new Customer(001,"ศศิธร", "สายพา", "88/131");
        cus.addPets(new Pets(001,"น้องโตโต้","ตัวผู้",2,"ไซบีเรีย","-","-","สุนัข"));
        cus.addPets(new Pets(002,"น้องปอย","ตัวเมีย",2,"เปอร์เซีย","-","-","แมว"));
        cusList.add(cus);
        ObservableList<String> cusL = FXCollections.observableArrayList(
                cus.getId()+" "+cus.getFirstName()
        );
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
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReservedPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));

//        ReservedController rc = loader.getController();
//        String[] c = customerList.getSelectionModel().getSelectedItems().get(0).toString().split(" ");
//        for (Customer cus:cusList) {
//            if (cus.getFirstName() == c[1]){
//                rc.setCustomer(cus);
//            }
//        }

        stage.show();

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
