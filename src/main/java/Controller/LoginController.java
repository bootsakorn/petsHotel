package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    protected TextField username;
    @FXML
    protected TextField password;
    @FXML
    protected Button loginBtn;
    @FXML
    protected void loginAction(ActionEvent e){
        System.out.println(username.getCharacters());
        System.out.println(password.getCharacters());
    }
}
