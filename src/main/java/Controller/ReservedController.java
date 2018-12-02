package Controller;

import Models.Customer;
import Models.Pets;
import Models.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.awt.*;
import java.io.IOException;
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
    @FXML protected AnchorPane formatAnchorPane;
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
    @FXML protected AnchorPane pet1Pane;
    @FXML protected ComboBox roomType;
    @FXML protected Button step2NextBtn;
    @FXML protected Button step2PreviousBtn;
    @FXML protected Parent root;
    @FXML protected Button a1,a2,a3,a4,a5,a6;
    @FXML protected Button b1,b2,b3,b4,b5,b6;
    @FXML protected Button c1,c2,c3,c4;
    @FXML protected Button d1,d2,d3;
    @FXML protected Button e1,e2;
    // confirmDetailTab
    @FXML protected Button checkInBtn;
    @FXML protected Button submitBtn;
    @FXML protected Button step3PreviousBtn;
    @FXML protected TextArea allDetails;

    private ArrayList<ArrayList<String>> petsDetail = new ArrayList();
    private ArrayList<Button> groupA = new ArrayList<>();
    private ArrayList<Button> groupB = new ArrayList<>();
    private ArrayList<Button> groupC = new ArrayList<>();
    private ArrayList<AnchorPane> groupD = new ArrayList<>();
    private ArrayList<AnchorPane> groupE = new ArrayList<>();
    private ArrayList<Pets> pets = new ArrayList<>();

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
    public void manageRoom(AnchorPane pane){
        pane.getChildren().get(1).setDisable(true);
        AnchorPane roomA = (AnchorPane)pane.getChildren().get(1);
        for (Node btn : roomA.getChildren() ) {
            btn.setStyle("-fx-background-color: #e07d7d");
        }
    }

    //insert detail tab
    public void handleOnClickedAddPetBtn(){
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

    public void handleOnClickedStep1NextBtn(ActionEvent actionEvent)throws Exception{
        if (petsDetail.isEmpty()){

        }else{
            SingleSelectionModel<Tab> selectionModel = reservationTab.getSelectionModel();
            selectionModel.select(chooseRooms);
            insertDetail.setDisable(true);
            chooseRooms.setDisable(false);
            ObservableList<String> roomTypes = FXCollections.observableArrayList(
                    "ห้องเดี่ยว","ห้องรวม"
            );
            roomType.setItems(roomTypes);

            //setting tab for step2 (choose room)
            if (petsDetail.size() == 1){
                String name = petsDetail.get(0).get(1);
                petTab1.setText(name);
            }else if(petsDetail.size() == chooseRoomTabPane.getTabs().size()){
                for (int i = 1 ; i < petsDetail.size() ; i++){
                    String name = petsDetail.get(i).get(1);
                    chooseRoomTabPane.getTabs().get(i).setText(name);
                }

            }
            else {
                String name = petsDetail.get(0).get(1);
                petTab1.setText(name);
                manageRoom(pet1Pane);
                petTab1.setContent(pet1Pane);
                for (int i = 1 ; i < petsDetail.size() ; i++){
                    Tab tab = new Tab(petsDetail.get(i).get(1));
                    AnchorPane pane = new AnchorPane();
                    createTabContent(pane);
                    manageRoom(pane);
                    tab.setContent(pane);
                    chooseRoomTabPane.getTabs().add(tab);
                }
            }
        }
    }

    public void createTabContent(AnchorPane pane){
        ObservableList<String> roomType = FXCollections.observableArrayList(
                "ห้องเดี่ยว","ห้องรวม"
        );
        pane.setPrefSize(655, 210);
        ComboBox cb = new ComboBox();
        cb.setMinWidth(160);
        cb.setLayoutX(40);
        cb.setLayoutY(30);
        cb.setPromptText("ชนิดห้อง");
        cb.setVisibleRowCount(10);
        cb.setItems(roomType);

        createButton();
        settingButton();

        AnchorPane roomA = new AnchorPane();
        roomA.setPrefSize(155, 180);
        roomA.setLayoutX(40);
        roomA.setLayoutY(110);
        roomA.setStyle("-fx-border-width: 2; -fx-border-color: grey;");
        for (Button btn : groupA) {
            roomA.getChildren().add(btn);
        }

        AnchorPane roomB = new AnchorPane();
        roomB.setPrefSize(230, 120);
        roomB.setLayoutX(205);
        roomB.setLayoutY(110);
        roomB.setStyle("-fx-border-width: 2; -fx-border-color: grey;");
        for (Button btn : groupB) {
            roomB.getChildren().add(btn);
        }

        AnchorPane roomC = new AnchorPane();
        roomC.setPrefSize(155, 120);
        roomC.setLayoutX(445);
        roomC.setLayoutY(110);
        roomC.setStyle("-fx-border-width: 2; -fx-border-color: grey;");
        for (Button btn : groupC) {
            roomC.getChildren().add(btn);
        }

        for (int i = 0; i < 3; i++) {
            groupD.add(new AnchorPane());
            groupD.get(i).setPrefSize(80, 58);
            if (i!=0){
                groupD.get(i).setLayoutX(groupD.get(i-1).getLayoutX() + 74);
                groupD.get(i).setLayoutY(groupD.get(i-1).getLayoutY());
            }else{
                groupD.get(i).setLayoutX(205);
                groupD.get(i).setLayoutY(230);
            }
            groupD.get(i).setStyle("-fx-border-width: 2; -fx-border-color: grey;");
            Button btn = new Button("D"+(i+1));
            btn.setPrefSize(60,40);
            btn.setStyle("-fx-background-color: #b4e5b5;");
            btn.setLayoutX(10);
            btn.setLayoutY(10);
            groupD.get(i).getChildren().add(btn);
        }

        for (int i = 0; i < 2; i++) {
            groupE.add(new AnchorPane());
            groupE.get(i).setPrefSize(80, 58);
            if (i!=0){
                groupE.get(i).setLayoutX(groupE.get(i-1).getLayoutX() + 74);
                groupE.get(i).setLayoutY(groupE.get(i-1).getLayoutY());
            }else{
                groupE.get(i).setLayoutX(445);
                groupE.get(i).setLayoutY(230);
            }
            groupE.get(i).setStyle("-fx-border-width: 2; -fx-border-color: grey;");
            Button btn = new Button("E"+(i+1));
            btn.setPrefSize(60,40);
            btn.setStyle("-fx-background-color: #b4e5b5;");
            btn.setLayoutX(10);
            btn.setLayoutY(10);
            groupE.get(i).getChildren().add(btn);
        }

        pane.getChildren().add(cb);
        pane.getChildren().add(roomA);
        pane.getChildren().add(roomB);
        pane.getChildren().add(roomC);
        for (AnchorPane d : groupD) {
            pane.getChildren().add(d);
        }
        for (AnchorPane e : groupE) {
            pane.getChildren().add(e);
        }
    }

    public void createButton(){
        for (int i = 1; i <= 6; i++) {
            groupA.add( new Button("A"+i));
            groupB.add( new Button("B"+i));
        }
        for (int i = 1; i <= 4; i++) {
            groupC.add( new Button("C"+i));
        }
    }

    public void settingButton(){
        int left = 70 , down = 55;
        for (int i = 0; i < 6; i++) {
            groupA.get(i).setPrefSize(60,40);
            groupA.get(i).setStyle("-fx-background-color: #b4e5b5;");
            groupB.get(i).setPrefSize(60,40);
            groupB.get(i).setStyle("-fx-background-color: #b4e5b5;");
            if (i % 2 == 0){
                if (i!=0){
                    groupA.get(i).setLayoutX(groupA.get(i-2).getLayoutX());
                    groupA.get(i).setLayoutY(groupA.get(i-2).getLayoutY() + down);
                    groupB.get(i).setLayoutX(groupB.get(i-2).getLayoutX() + left);
                    groupB.get(i).setLayoutY(groupB.get(i-2).getLayoutY());
                }else {
                    groupA.get(i).setLayoutX(15);
                    groupA.get(i).setLayoutY(10);
                    groupB.get(i).setLayoutX(10);
                    groupB.get(i).setLayoutY(10);
                }
            }else{
                if (i!=1){
                    groupA.get(i).setLayoutX(groupA.get(i-2).getLayoutX());
                    groupA.get(i).setLayoutY(groupA.get(i-2).getLayoutY() + down);
                    groupB.get(i).setLayoutX(groupB.get(i-2).getLayoutX() + left);
                    groupB.get(i).setLayoutY(groupB.get(i-2).getLayoutY());
                }else {
                    groupA.get(i).setLayoutX(85);
                    groupA.get(i).setLayoutY(10);
                    groupB.get(i).setLayoutX(10);
                    groupB.get(i).setLayoutY(65);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            groupC.get(i).setPrefSize(60,40);
            groupC.get(i).setStyle("-fx-background-color: #b4e5b5;");
            if (i%2 == 0){
                if (i!=0){
                    groupC.get(i).setLayoutX(groupC.get(i-2).getLayoutX() + left);
                    groupC.get(i).setLayoutY(groupC.get(i-2).getLayoutY());
                }else{
                    groupC.get(i).setLayoutX(10);
                    groupC.get(i).setLayoutY(10);
                }
            }else{
                if (i!=1){
                    groupC.get(i).setLayoutX(groupC.get(i-2).getLayoutX() + left);
                    groupC.get(i).setLayoutY(groupC.get(i-2).getLayoutY());
                }else {
                    groupC.get(i).setLayoutX(10);
                    groupC.get(i).setLayoutY(65);
                }
            }
        }
    }

    public void handleOnClickedStep2NextBtn(ActionEvent actionEvent) {
        SingleSelectionModel<Tab> selectionModel = reservationTab.getSelectionModel();
        selectionModel.select(confirmDetail);
        chooseRooms.setDisable(true);
        confirmDetail.setDisable(false);
    }

    public void handleOnClickedStep2PreviousBtn(ActionEvent actionEvent) {
        SingleSelectionModel<Tab> selectionModel = reservationTab.getSelectionModel();
        selectionModel.select(insertDetail);
        insertDetail.setDisable(false);
        chooseRooms.setDisable(true);
    }

    public void handleOnClickedCheckInBtn(ActionEvent actionEvent) {
    }

    public void handleOnClickedSubmitBtn(ActionEvent actionEvent) {
    }

    public void handleOnClickedStep3PreviousBtn(ActionEvent actionEvent) {
        SingleSelectionModel<Tab> selectionModel = reservationTab.getSelectionModel();
        selectionModel.select(chooseRooms);
        chooseRooms.setDisable(false);
        confirmDetail.setDisable(true);
    }

    public void handleOnClickedSelectedRoomType(ActionEvent actionEvent) {
    }

    public void handleOnClickedSelectedRoom(ActionEvent actionEvent) {
    }
}
