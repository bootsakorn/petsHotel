package Controller;

import Controller.dataController.DataController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustomerPageController extends CounterPageController {

    @FXML protected TextField fnameField;
    @FXML protected TextField lnameField;
    @FXML protected TextArea addressField;
    @FXML protected TextField petNameField;
    @FXML protected TextField ageField;
    @FXML protected TextField breedField;
    @FXML protected TextField diseaseField;
    @FXML protected TextField allergyField;
    @FXML protected Button submitBtn;
    @FXML protected Button cancelBtn;
    @FXML protected ComboBox sexComboBox;
    @FXML protected ComboBox speciesComboBox;
    private String fname = "", lname = "", address = "";
    private String pname = "",sex = "ผู้", age = "", species = "สุนัข", breed = "", disease = "", allergy = "";
    private DataController dataController;

    public AddCustomerPageController(){
        try {
            this.dataController = new DataController();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML private void initialize(){
        ObservableList<String> sex = FXCollections.observableArrayList("ผู้","เมีย");
        ObservableList<String> species = FXCollections.observableArrayList("สุนัข","แมว","กระต่าย");
        sexComboBox.setItems(sex);
        speciesComboBox.setItems(species);
        sexComboBox.getSelectionModel().selectFirst();
        speciesComboBox.getSelectionModel().selectFirst();
    }

    @FXML protected void handleOnClickedSubmitBtn(ActionEvent event) {
        //cutomer
        fname = fnameField.getText();
        lname = lnameField.getText();
        address = addressField.getText();

        //pet
        pname = petNameField.getText();
            //sex text is in sex variable
        age = ageField.getText();
            //species text is in species variable
        breed = breedField.getText();
        disease = diseaseField.getText();
        allergy = allergyField.getText();

        //insert to database here
        dataController.insertNewCustomer(fname, lname, address, pname, Integer.valueOf(age), sex, breed, disease, allergy, species);

    }

    @FXML protected void handleOnClickedCancelBtn(ActionEvent event) throws Exception{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CounterPage.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        stage.show();
    }

    @FXML protected void handleOnClickedSelectSexComboBox(ActionEvent event) {
        sex = sexComboBox.getSelectionModel().getSelectedItem().toString();
    }

    @FXML protected void handleOnClickedSelectSpeciesComboBox(ActionEvent event) {
        species = speciesComboBox.getSelectionModel().getSelectedItem().toString();
    }
}
