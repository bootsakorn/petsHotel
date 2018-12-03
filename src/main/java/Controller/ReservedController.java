package Controller;

import Controller.dataController.DataController;
import Models.*;
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
import javafx.scene.control.TextField;
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
    @FXML protected TextField dayNum;
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
    private Customer cus;
    private ArrayList<Pets> pets;
    private FoodStorage fs = new FoodStorage();
    private String type = "ห้องเดี่ยว";
    private DataController data = new DataController();
//    private ArrayList<Room> roomList = 

    @FXML private void initialize(){
        cus = new Customer(001,"ศศิธร", "สายพา", "88/131");
        cus.addPets(new Pets(001,"น้องโตโต้","ตัวผู้",2,"ไซบีเรีย","-","-","สุนัข"));
        cus.addPets(new Pets(002,"น้องปอย","ตัวเมีย",2,"เปอร์เซีย","-","-","แมว"));
        cus.addPets(new Pets(003,"น้องโอ๋เอ๋","ตัวผู้",1,"แคระ","-","-","กระต่าย"));
        //prep Data
        manageDatePicker();
        managePetList();
        manageFoodList();
    }

    private void manageDatePicker(){
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
        cus.getId();
        pets = cus.getPets();
        ArrayList petNames = new ArrayList();
        for (Pets p:pets){
            petNames.add(p.getName());
        }
        ObservableList<String> petName = FXCollections.observableArrayList(petNames);
//        ObservableList<String> petName = FXCollections.observableArrayList("น้องโตโต้","น้องปอย");
        petList.setValue(petName.get(0));
        petList.setItems(petName);
    }

    public void manageFoodList(){
//        fs.add("วิสกัส",100);
//        fs.add("เพ็ดดีกรี",100);
//        ArrayList foodNames = new ArrayList();
//        for (Food f: fs.getFoods()){
//            foodNames.add(f.getName());
//        }
//        ObservableList<String> foodName = FXCollections.observableArrayList(foodNames);
        ObservableList<String> foodName = FXCollections.observableArrayList("วิสกัส","เพ็ดดีกรี");
        foodList.setValue(foodName.get(0));
        foodList.setItems(foodName);
    }
    public void manageRoom(AnchorPane pane,int petIndex){
        String species = pets.get(petIndex).getSpecies();
        AnchorPane roomA = (AnchorPane) pane.getChildren().get(1);
        AnchorPane roomB = (AnchorPane) pane.getChildren().get(2);
        AnchorPane roomC = (AnchorPane) pane.getChildren().get(3);
        AnchorPane roomD1 = (AnchorPane) pane.getChildren().get(4);
        AnchorPane roomD2 = (AnchorPane) pane.getChildren().get(5);
        AnchorPane roomD3 = (AnchorPane) pane.getChildren().get(6);
        AnchorPane roomE1 = (AnchorPane) pane.getChildren().get(7);
        AnchorPane roomE2 = (AnchorPane) pane.getChildren().get(8);
        if (species.equalsIgnoreCase("แมว")) {
            roomA.setDisable(true);
            roomC.setDisable(true);
            roomE1.setDisable(true);
            roomE2.setDisable(true);
            for (Node btn : roomA.getChildren()) {
                btn.setStyle("-fx-background-color: #e07d7d");
            }
            for (Node btn : roomC.getChildren()) {
                btn.setStyle("-fx-background-color: #e07d7d");
            }
            roomE1.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
            roomE2.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");

            if (type.equalsIgnoreCase("ห้องเดี่ยว")){
                roomB.setDisable(true);
                for (Node btn : roomB.getChildren()) {
                    btn.setStyle("-fx-background-color: #e07d7d");
                }
                roomD1.setDisable(false);
                roomD2.setDisable(false);
                roomD3.setDisable(false);
                roomD1.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5");
                roomD2.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5");
                roomD3.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5");
            }else {
                roomB.setDisable(false);
                for (Node btn : roomB.getChildren()) {
                    btn.setStyle("-fx-background-color: #b4e5b5");
                }
                roomD1.setDisable(true);
                roomD2.setDisable(true);
                roomD3.setDisable(true);
                roomD1.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
                roomD2.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
                roomD3.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
            }
        } else if (species.equalsIgnoreCase("สุนัข")) {
            roomB.setDisable(true);
            roomC.setDisable(true);
            roomD1.setDisable(true);
            roomD2.setDisable(true);
            roomD3.setDisable(true);
            for (Node btn : roomB.getChildren()) {
                btn.setStyle("-fx-background-color: #e07d7d");
            }
            for (Node btn : roomC.getChildren()) {
                btn.setStyle("-fx-background-color: #e07d7d");
            }
            roomD1.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
            roomD2.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
            roomD3.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");

            if (type.equalsIgnoreCase("ห้องเดี่ยว")){
                roomA.setDisable(true);
                for (Node btn : roomA.getChildren()) {
                    btn.setStyle("-fx-background-color: #e07d7d");

                }
                roomE1.setDisable(false);
                roomE2.setDisable(false);
                roomE1.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5");
                roomE2.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5");
            }else {
                roomA.setDisable(false);
                for (Node btn : roomA.getChildren()) {
                    btn.setStyle("-fx-background-color: #b4e5b5");

                }
                roomE1.setDisable(true);
                roomE2.setDisable(true);
                roomE1.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
                roomE2.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
            }
        }else if (species.equalsIgnoreCase("กระต่าย")){
            roomA.setDisable(true);
            roomB.setDisable(true);
            roomC.setDisable(true);
            roomD1.setDisable(true);
            roomD2.setDisable(true);
            roomD3.setDisable(true);
            for (Node btn : roomA.getChildren()) {
                btn.setStyle("-fx-background-color: #e07d7d");
            }
            for (Node btn : roomB.getChildren()) {
                btn.setStyle("-fx-background-color: #e07d7d");
            }
            for (Node btn : roomC.getChildren()) {
                btn.setStyle("-fx-background-color: #e07d7d");
            }
            roomD1.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
            roomD2.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
            roomD3.getChildren().get(0).setStyle("-fx-background-color: #e07d7d");
        }
    }

    //insert detail tab
    public void handleOnClickedAddPetBtn(){
        RadioButton selected = (RadioButton)servicePackage.getSelectedToggle();
        ObservableList<String> pet = addedListView.getItems();
        pet.add(datePicker.getValue()+" | "+petList.getValue()+" | "+foodList.getValue()
                +" | "+selected.getText()+" | "+dayNum.getText()+" วัน");
        addedListView.setItems(pet);

        petsDetail.add(new ArrayList(Arrays.asList(
                datePicker.getValue().toString(),
                petList.getValue().toString(),
                foodList.getValue().toString(),
                selected.getText(),dayNum.getText()+" วัน"
                )));
        System.out.println(datePicker.getValue()+" "+petList.getValue()+" "+foodList.getValue()
                +" "+((RadioButton)servicePackage.getSelectedToggle()).getText()+" "+dayNum.getText()+" วัน");
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
            roomType.getSelectionModel().selectFirst();

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
                manageRoom(pet1Pane, 0);
                petTab1.setContent(pet1Pane);
                for (int i = 1 ; i < petsDetail.size() ; i++){
                    Tab tab = new Tab(petsDetail.get(i).get(1));
                    AnchorPane pane = new AnchorPane();
                    createTabContent(pane);
                    manageRoom(pane,i);
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
        cb.setId("roomType2");
        cb.getSelectionModel().selectFirst();
        cb.setOnAction( event -> {
            if (cb.getValue().toString().equalsIgnoreCase("ห้องเดี่ยว")){
                type = "ห้องเดี่ยว";
                manageRoom(pane,1);
            }else { type = "ห้องรวม"; }
            manageRoom(pane,1);
        });

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
            groupA.add( new Button("A"+i)); //groupA
            groupB.add( new Button("B"+i)); //groupB
        }
        for (int i = 1; i <= 4; i++) {
            groupC.add( new Button("C"+i)); //groupC
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

    public void handleOnClickedSelectedRoomType() {
        if (roomType.getSelectionModel().isSelected(0)){
            type = "ห้องเดี่ยว";
            manageRoom(pet1Pane,0);
        }else if (roomType.getSelectionModel().isSelected(1)){
            type = "ห้องรวม";
            manageRoom(pet1Pane,0);
        }
    }

    public void handleOnClickedSelectedRoom(ActionEvent actionEvent) {
    }

    public Customer getCustomer() {
        return cus;
    }
    public void setCustomer(Customer customer) {
        this.cus = customer;
    }
}
