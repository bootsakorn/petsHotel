package Controller;

import Controller.dataController.DataController;
import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class CheckOutController extends CounterPageController {

    @FXML protected AnchorPane mainPane;
    @FXML protected TextField searchTextField;
    @FXML protected TableView recieveBillNumList;
    @FXML protected TableColumn noCol, dateCol, nameCol, petCol;
    @FXML protected Button CheckOutBtn;
    @FXML protected AnchorPane successPane;
    @FXML protected Button okBtn;
    private DataController dataController;
    private ArrayList<Customer> customers;
    private ArrayList<CheckIn> checkIns;
    private ArrayList<AppointmentBill> appBills;

    public CheckOutController(){
        try {
            dataController = new DataController();
            customers = dataController.getCustomer();
            checkIns = dataController.getCheckIns();
            appBills = dataController.getAppointmentBills();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        dataController.getData();
        ObservableList<CheckOutDataForTableView> list = recieveBillNumList.getItems();
        noCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        petCol.setCellValueFactory(new PropertyValueFactory<>("petName"));

        for (CheckIn c:checkIns) {
            if (dataController.getCheckInByResereveId(c.getId()) == null) {
                TakingCarePetsList tk = dataController.getTKCListById(dataController.getAppbillById(c.getAppointment_bill_id()).getTakingCarePetsListId());
                CheckOutDataForTableView item = new CheckOutDataForTableView(
                        c.getId(),
                        dataController.getAppbillById(c.getAppointment_bill_id()).getAppointmentDate()+"",
                        dataController.getCustomerById(tk.getCustomerId()).getFirstName(),
                        dataController.getPetById(tk.getPetId()).getName()
                );
                list.add(item);
            }
        }
        recieveBillNumList.setItems(list);
    }

    public void handleOnClickedCheckOutBtn(ActionEvent event) {
        mainPane.setVisible(false);
        successPane.setVisible(true);

        CheckOutDataForTableView selected = (CheckOutDataForTableView)recieveBillNumList.getSelectionModel().getSelectedItem();
        dataController.checkout(selected.getId());
    }

    public void handleOnClickedOkBtn(ActionEvent event) {
        mainPane.setVisible(true);
        successPane.setVisible(false);
    }

    public void handleOnClickSearchBtn(ActionEvent event) {
    }
}
