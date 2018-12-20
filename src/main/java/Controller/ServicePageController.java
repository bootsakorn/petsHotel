package Controller;

import Controller.dataController.DataController;
import Controller.dataController.SalonDataController;
import Controller.dataController.ServiceDataController;
import Models.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ServicePageController extends  PageSwitchController{
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;
    @FXML protected Button toDoneList;
    @FXML protected Button toToDoList;
    @FXML protected ListView toDoList,doneList,detailList;
    private DataController dc;
    private ServiceDataController sdc;
    private Service service;
    private ArrayList<Service> services;

    public ServicePageController(){
        try {
            this.dc = new DataController();
            this.sdc = new ServiceDataController();
            this.services = dc.getService();
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
        String selected[] = listView.getSelectionModel().getSelectedItem().toString().split(" ");
        for (Service service:services) {
            if (service.getPetName().equals(selected[0]) && service.getDate().equals("21-12-2018")){
                this.service = service;
            }
        }
        String detail[] = service.getDetail().split(" ");
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
        String selected[] = doneList.getSelectionModel().getSelectedItem().toString().split(" ");
        for (Service service:services) {
            if (service.getPetName().equals(selected[0]) && service.getDate().equals("21-12-2018")){
                this.service = service;
            }
        }
        sdc.editStatus(service.getId(),0);
        dc.getData();
        services = dc.getService();
        showtodo();
        showdone();
    }
    @FXML
    protected void handleOnClickToDoneListBtn(ActionEvent e){
        ObservableList<String> detailListItems = FXCollections.observableArrayList();
        detailList.setItems(detailListItems);
        String selected[] = toDoList.getSelectionModel().getSelectedItem().toString().split(" ");
        for (Service service:services) {
            if (service.getPetName().equals(selected[0]) && service.getDate().equals("21-12-2018")){
                this.service = service;
            }
        }
        sdc.editStatus(service.getId(),1);
        dc.getData();
        services = dc.getService();
        showtodo();
        showdone();
    }

    private void showtodo(){
        ObservableList<String> todos = FXCollections.observableArrayList();
        toDoList.setItems(todos);
        todos =  toDoList.getItems();
        for (Service service:services) {
            if (!service.getStatus()){
                todos.add(service.getPetName()+" ห้อง "+ dc.getRoomById(service.getRoom()).getName().toUpperCase());
            }
        }
        toDoList.setItems(todos);
    }
    private void showdone(){
        ObservableList<String> dones = FXCollections.observableArrayList();
        doneList.setItems(dones);
        dones =  doneList.getItems();
        for (Service service:services) {
            if (service.getStatus()){
                dones.add(service.getPetName()+" ห้อง "+ dc.getRoomById(service.getRoom()).getName().toUpperCase());
            }
        }
        doneList.setItems(dones);
    }



}
