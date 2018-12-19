package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class SalonPageController extends PageSwitchController{
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;
    @FXML protected Button toDoneList;
    @FXML protected Button toToDoList;
    @FXML protected ListView toDoList,doneList;

    @FXML
    protected void handleToDoListView(ActionEvent e){
        // get toDolist
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
