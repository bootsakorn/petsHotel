package Controller;

import Controller.dataController.CustomersDataController;
import Models.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CounterPageController extends PageSwitchController{
    final ObservableList<CustomersDataController> data = FXCollections.observableArrayList();
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
    @FXML protected TextField searchTextField;
    @FXML protected TableView table;
    @FXML protected Button reserveBtnOnTopPage;
    @FXML protected Button checkInBtn;
    @FXML protected Button checkOutBtn;
    @FXML protected Button roomBtn;
    @FXML private Parent root ;

    //Button On Top
    @FXML protected void handleOnClickReserveBtnOnTopPage(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CounterPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }

    //Button on center
    @FXML protected void handleOnClickSearchTextfield(ActionEvent e){

    }
    @FXML protected void handleOnClickAddBtn(ActionEvent e) throws Exception{
        //add
    }
    @FXML protected void handleOnClickReserveBtn(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReservedPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }
}
