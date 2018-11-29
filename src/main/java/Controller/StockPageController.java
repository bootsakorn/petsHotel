package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class StockPageController extends PageSwitchController{
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;

    @FXML protected Button addBtn;
    @FXML protected ListView stockList;

    @FXML protected void handleOnClickAddBtn(ActionEvent e) throws Exception{
        //add
    }
}
