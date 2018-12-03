package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CheckOutController extends CounterPageController {

    public AnchorPane mainPane;
    public TextField searchTextField;
    public ListView recieveBillNumList;
    public Button CheckOutBtn;
    public AnchorPane successPane;
    public Button okBtn;

    @FXML
    private void initialize(){

    }

    public void handleOnClickedCheckOutBtn(ActionEvent event) {
        mainPane.setVisible(false);
        successPane.setVisible(true);
    }

    public void handleOnClickedOkBtn(ActionEvent event) {
        mainPane.setVisible(true);
        successPane.setVisible(false);
    }

    public void handleOnClickSearchBtn(ActionEvent event) {
    }
}
