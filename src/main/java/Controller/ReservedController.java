package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class ReservedController extends PageSwitchController{
    
    @FXML protected MenuItem home;
    @FXML protected MenuItem calendar;
    @FXML protected MenuItem logout;
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;
    //Tab
    @FXML protected TabPane reservationTab;
    @FXML protected Tab insertDetail;
    @FXML protected Tab chooseRooms;
    @FXML protected Tab confirmDetail;
    @FXML protected TabPane chooseRoomTabPane;
    @FXML protected Tab petTab1;
    //insertDetailTab
    @FXML protected DatePicker datePicker;
    @FXML protected ChoiceBox petList;
    @FXML protected ChoiceBox foodList;
    @FXML protected RadioButton normalPackage;
    @FXML protected RadioButton silverPackage;
    @FXML protected RadioButton goldPackage;
    @FXML protected Button addPetBtn;
    @FXML protected Button step1NextBtn;
    @FXML protected ListView addedListView;
    @FXML protected ToggleGroup servicePackage;
    //chooseRoomsTab
    @FXML protected Button step2NextBtn;
    @FXML protected Button step2PreviousBtn;
    @FXML protected ComboBox typeRooms;
    @FXML protected Button typeA;
    @FXML protected Button typeB;
    @FXML protected Button typeC;
    @FXML protected Button typeD;
    @FXML protected Button typeE;
    // confirmDetailTab
    @FXML protected TextArea allDetails;

    private ArrayList<ArrayList<String>> petsDetail = new ArrayList();

    @FXML private void initialize(){
        //prep Data
        manageDatePicker();
        managePetList();
        manageFoodList();
    }

    public void manageDatePicker(){
        // Converter
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        // Factory to create Cell of DatePicker
        Callback<DatePicker, DateCell> dayCellFactory= this.getDayCellFactory();
        //setting date picker
        datePicker.setConverter(converter);
        datePicker.setValue(LocalDate.now());
        datePicker.setPromptText("dd-MM-yyyy");
        datePicker.setDayCellFactory(dayCellFactory);
    }

    // Factory to create Cell of DatePicker
    private Callback<DatePicker, DateCell> getDayCellFactory() {

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {

            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        // Disable Date before today
                        if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        return dayCellFactory;
    }

    public void managePetList(){
        ObservableList<String> petName = FXCollections.observableArrayList(
                "น้องโตโต้","น้องไอซ์","น้องปอย"
        );
        petList.setValue(petName.get(0));
        petList.setItems(petName);
    }

    public void manageFoodList(){
        ObservableList<String> foodName = FXCollections.observableArrayList(
                "วิสกี้","เพ็ดดีกรี","Orijen"
        );
        foodList.setValue(foodName.get(0));
        foodList.setItems(foodName);
    }

    //insert detail tab
    public void handleOnClickedAddPetBtn() {
        RadioButton selected = (RadioButton)servicePackage.getSelectedToggle();
        ObservableList<String> pet = addedListView.getItems();
        pet.add(datePicker.getValue()+" | "+petList.getValue()+" | "+foodList.getValue()
                +" | "+selected.getText());
        addedListView.setItems(pet);

        petsDetail.add(new ArrayList(Arrays.asList(
                datePicker.getValue().toString(),
                petList.getValue().toString(),
                foodList.getValue().toString(),
                selected.getText()
                )));
        System.out.println(datePicker.getValue()+" "+petList.getValue()+" "+foodList.getValue()
                +" "+((RadioButton)servicePackage.getSelectedToggle()).getText());
    }

    public void handleOnClickedStep1NextBtn(ActionEvent actionEvent) {
        SingleSelectionModel<Tab> selectionModel = reservationTab.getSelectionModel();
        selectionModel.select(chooseRooms);
        insertDetail.setDisable(true);
        chooseRooms.setDisable(false);

        //setting tab for step2 (choose room)
        if (petsDetail.size() == 1){
            String name = petsDetail.get(0).get(1);
            petTab1.setText(name);
        }else {
            String name = petsDetail.get(0).get(1);
            petTab1.setText(name);
            for (int i = 1 ; i < petsDetail.size() ; i++){
                Tab tab = new Tab(petsDetail.get(i).get(1));
                chooseRoomTabPane.getTabs().add(tab);
            }
        }

    }

    public void handleOnClickedStep2NextBtn(ActionEvent actionEvent) {
    }

    public void handleOnClickedStep2PreviousBtn(ActionEvent actionEvent) {
        SingleSelectionModel<Tab> selectionModel = reservationTab.getSelectionModel();
        selectionModel.select(insertDetail);
        insertDetail.setDisable(false);
        chooseRooms.setDisable(true);
    }
}
