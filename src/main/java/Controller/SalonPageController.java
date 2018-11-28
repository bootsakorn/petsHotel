package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SalonPageController {
    @FXML
    protected Button counterBtn;
    @FXML
    protected Button paperBtn;
    @FXML
    protected Button salonBtn;
    @FXML
    protected Button serviceBtn;
    @FXML
    protected Button stockBtn;


    @FXML
    protected void number(ActionEvent e){
        System.out.println("4");
    }
    @FXML
    protected void handleOnClickCounterBtn(ActionEvent e){
        // go to CounterPage
    }
    @FXML
    protected void handleOnClickPaperBtn(ActionEvent e){}
    @FXML
    protected void handleOnClickSalonBtn(ActionEvent e){}
    @FXML
    protected void handleOnClickServiceBtn(ActionEvent e){}
    @FXML
    protected void handleOnClickStockBtn(ActionEvent e){}
}
