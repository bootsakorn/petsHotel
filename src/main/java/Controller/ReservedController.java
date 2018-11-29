package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ReservedController {
    @FXML protected MenuItem home;
    @FXML protected MenuItem calendar;
    @FXML protected MenuItem logout;
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;
    //Tab
    @FXML protected Tab insertDetail;
    @FXML protected Tab chooseRooms;
    @FXML protected Tab confirmDetail;
    // insertDetail
    @FXML protected ChoiceBox petName;
    @FXML protected ChoiceBox foodName;
    @FXML protected RadioMenuItem choosePro;
    @FXML protected Button addMorePets;
    //chooseRooms
    @FXML protected ComboBox typeRooms;
    @FXML protected Button typeA;
    @FXML protected Button typeB;
    @FXML protected Button typeC;
    @FXML protected Button typeD;
    @FXML protected Button typeE;
    @FXML protected Button nextBtn; // อาจไม่จำเป็นต้องใช้
    // confirmDetail
    @FXML protected TextArea allDetails;

    // Button on top
    @FXML protected void handleOnClickHomeMenuItem(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/HomePage.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();

    }
    @FXML protected void handleOnClickCalendarMenuItem(ActionEvent e) throws Exception{
        //create calendar
    }
    @FXML protected void handleOnClickLogOutMenuItem(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();
    }

    // Button at Left side
    @FXML protected void handleOnClickCounterBtn(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/CounterPage.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();
    }
    @FXML protected void handleOnClickPaperBtn(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/PaperPage.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();
    }
    @FXML protected void handleOnClickSalonBtn(ActionEvent e)throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/SalonPage.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();
    }
    @FXML protected void handleOnClickServiceBtn(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/ServicePage.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();
    }
    @FXML protected void handleOnClickStockBtn(ActionEvent e)throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/StockPage.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();
    }
    // Button on center
    //insert detail tab
    @FXML protected void handleOnClick(ActionEvent e) throws Exception{
        Button button = (Button) e.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
        stage.setScene(new Scene(loader));
        stage.show();

    }


}
