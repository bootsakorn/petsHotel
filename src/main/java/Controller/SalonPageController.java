package Controller;

import Controller.dataController.DataController;
import Models.Salon;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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
    private ArrayList<Salon> salons;

    public SalonPageController(){
        try {
            this.dc = new DataController();
            this.salons = dc.getSalon();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize(){
        ObservableList<String> todos =  toDoList.getItems();
        for (Salon salon:salons) {
            todos.add(salon.getPetName());
        }
        toDoList.setItems(todos);
    }

    @FXML
    protected void handleToDoListView(ActionEvent e){

    }
    @FXML
    protected void handleDoneListView(ActionEvent e){
        // get donelist
    }
    @FXML
    protected void handleOnClickToToDoListBtn(ActionEvent e){
        // move selected data to todolist
    }
    @FXML
    protected void handleOnClickToDoneListBtn(ActionEvent e){
        // move select data to donelist
    }


}
