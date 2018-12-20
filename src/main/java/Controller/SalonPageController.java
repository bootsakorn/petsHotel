package Controller;

import Controller.dataController.DataController;
import Controller.dataController.SalonDataController;
import Models.Salon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class SalonPageController extends PageSwitchController{
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;
    @FXML protected Button toDoneList;
    @FXML protected Button toToDoList;
    @FXML protected ListView toDoList,doneList,detailList;
    private Salon salon;
    private DataController dc;
    private SalonDataController sdc;
    private ArrayList<Salon> salons;

    public SalonPageController(){
        try {
            this.dc = new DataController();
            this.sdc = new SalonDataController();
            this.salons = dc.getSalon();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize(){
        showtodo();
    }

    @FXML
    protected void handleToDoListView(MouseEvent e){
        ObservableList<String> detailListItems = FXCollections.observableArrayList();
        detailList.setItems(detailListItems);
        ListView listView = (ListView) e.getSource();
        String selected = listView.getSelectionModel().getSelectedItem().toString();
        for (Salon salon:salons){
            if (salon.getPetName().equals(selected) && salon.getDate().equals("21-12-2018")){
                this.salon = salon;
            }
        }
        String detail[] = salon.getDetail().split(" ");
        detailListItems = detailList.getItems();
        for (String d:detail) {
            detailListItems.add(d);
        }
        detailList.setItems(detailListItems);
    }
    @FXML
    protected void handleOnClickToToDoListBtn(ActionEvent e){
        ObservableList<String> detailListItems = FXCollections.observableArrayList();
        detailList.setItems(detailListItems);
        String selected = doneList.getSelectionModel().getSelectedItem().toString();
        for (Salon salon:salons){
            if (salon.getPetName().equals(selected) && salon.getDate().equals("21-12-2018")){
                this.salon = salon;
            }
        }
        sdc.editStatus(salon.getId(),0);
        dc.getData();
        salons = dc.getSalon();
        showtodo();
        showdone();
    }
    @FXML
    protected void handleOnClickToDoneListBtn(ActionEvent e){
        ObservableList<String> detailListItems = FXCollections.observableArrayList();
        detailList.setItems(detailListItems);
        String selected = toDoList.getSelectionModel().getSelectedItem().toString();
        for (Salon salon:salons){
            if (salon.getPetName().equals(selected) && salon.getDate().equals("21-12-2018")){
                this.salon = salon;
            }
        }
        sdc.editStatus(salon.getId(),1);
        dc.getData();
        salons = dc.getSalon();
        showtodo();
        showdone();
    }

    private void showtodo(){
        ObservableList<String> todos = FXCollections.observableArrayList();
        toDoList.setItems(todos);
        todos =  toDoList.getItems();
        for (Salon salon:salons) {
            if (!salon.getStatus()){
                todos.add(salon.getPetName());
            }
        }
        toDoList.setItems(todos);
    }
    private void showdone(){
        ObservableList<String> dones = FXCollections.observableArrayList();
        doneList.setItems(dones);
        dones =  doneList.getItems();
        for (Salon salon:salons) {
            if (salon.getStatus()){
                dones.add(salon.getPetName());
            }
        }
        doneList.setItems(dones);
    }

}
