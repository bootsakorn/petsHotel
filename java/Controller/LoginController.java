package Controller;

import Controller.dataController.LoginDataController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.rmi.server.ExportException;

public class LoginController {
    @FXML protected TextField username;
    @FXML protected TextField password;
    @FXML protected Button loginBtn;
    //private LoginDataController logInDB;
    @FXML protected void loginAction(ActionEvent e)  {
        System.out.println(username.getCharacters());
        System.out.println(password.getCharacters());
    }
    @FXML
    protected void  handleOnClickLoginButton(ActionEvent e) throws Exception {
//        //if(username.getText().equals(logInDB.getUsernames())&& password.getText().equals(logInDB.getPassword(username.toString()))){
//            Button b = (Button) e.getSource();
//            Stage stage = (Stage) b.getScene().getWindow();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
//            //try {
//            stage.setScene(new Scene(loader.load()));
//            stage.show();
////            } catch (IOException e1) {
////                e1.printStackTrace();
////            }
//       // }
//
//        //else{Alert alertMessage = new Alert(Alert.AlertType.WARNING);
//        //                alertMessage.setHeaderText(null);
//        //                alertMessage.setContentText"Username or Password is wrong!!! \n Please Try again.");
//        //                alertMessage.showAndWait();(}
    }
}
