package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Arrays;

public class RoomPageController extends CounterPageController {

    @FXML protected AnchorPane groupA;
    @FXML protected AnchorPane groupB;
    @FXML protected AnchorPane groupC;
    @FXML protected AnchorPane groupD1;
    @FXML protected AnchorPane groupD2;
    @FXML protected AnchorPane groupD3;
    @FXML protected AnchorPane groupE1;
    @FXML protected AnchorPane groupE2;
    @FXML protected ComboBox species;
    @FXML protected ComboBox roomType;
    @FXML protected Button a1,a2,a3,a4,a5,a6,
                            b1,b2,b3,b4,b5,b6,
                            c1,c2,c3,c4,
                            d1,d2,d3,e1,e2;
    private String selectedType = "";
    private String selectedSpecies = "";
//    private ArrayList<Button> groupA = new ArrayList<>(Arrays.asList(a1,a2,a3,a4,a5,a6));
//    private ArrayList<Button> groupB = new ArrayList<>(Arrays.asList(b1,b2,b3,b4,b5,b6));
//    private ArrayList<Button> groupC = new ArrayList<>(Arrays.asList(c1,c2,c3,c4));
//    private ArrayList<Button> groupD = new ArrayList<>(Arrays.asList(d1,d2,d3));
//    private ArrayList<Button> groupE = new ArrayList<>(Arrays.asList(e1,e2));

    @FXML private void initialize(){
        ObservableList<String> roomType = FXCollections.observableArrayList(
                "ห้องเดี่ยว","ห้องรวม"
        );
        ObservableList<String> species = FXCollections.observableArrayList(
                "แมว","สุนัข","กระต่าย"
        );
        this.roomType.setItems(roomType);
        this.species.setItems(species);
    }

    public void handleOnClickedSelectedSpecies(ActionEvent event) {
        if (species.getSelectionModel().isSelected(0)){
            selectedSpecies = "แมว";
        }else if (species.getSelectionModel().isSelected(1)){
            selectedSpecies = "สุนัข";
        }else if (species.getSelectionModel().isSelected(2)){
            selectedSpecies = "กระต่าย";
        }
        manageRoom();
    }

    public void handleOnClickedSelectedRoomType(ActionEvent event) {
        if (roomType.getSelectionModel().isSelected(0)){
            selectedType = "ห้องเดี่ยว";
        }else{
            selectedType = "ห้องรวม";
        }
        manageRoom();
    }

    public void handleOnClickedSelectedRoom(ActionEvent event) {
    }

    private void manageRoom(){
        if (selectedSpecies.equalsIgnoreCase("แมว")){
            if (selectedType.equalsIgnoreCase("ห้องเดี่ยว")){
                for (Node btn: groupB.getChildren()) {
                    btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
                }
                groupD1.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
                groupD2.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
                groupD3.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
            }else if (selectedType.equalsIgnoreCase("ห้องรวม")){
                for (Node btn: groupB.getChildren()) {
                    btn.setStyle("-fx-background-color: #b4e5b5;"); //green
                }
                groupD1.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
                groupD2.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
                groupD3.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
            }else {
                for (Node btn: groupB.getChildren()) {
                    btn.setStyle("-fx-background-color: #b4e5b5;"); //green
                }
                groupD1.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
                groupD2.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
                groupD3.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
            }
            for (Node btn: groupA.getChildren()) {
                btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
            }

            for (Node btn: groupC.getChildren()) {
                btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
            }
            groupE1.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
            groupE2.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
        }else if (selectedSpecies.equalsIgnoreCase("สุนัข")){
            if (selectedType.equalsIgnoreCase("ห้องเดี่ยว")){
                for (Node btn: groupA.getChildren()) {
                    btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
                }
                groupE1.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
                groupE2.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
            }else if (selectedType.equalsIgnoreCase("ห้องรวม")){
                for (Node btn: groupA.getChildren()) {
                    btn.setStyle("-fx-background-color: #b4e5b5;"); //green
                }
                groupE1.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
                groupE2.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
            }else{
                for (Node btn: groupA.getChildren()) {
                    btn.setStyle("-fx-background-color: #b4e5b5;"); //green
                }
                groupE1.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
                groupE2.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
            }
            for (Node btn: groupB.getChildren()) {
                btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
            }
            for (Node btn: groupC.getChildren()) {
                btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
            }
            groupD1.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
            groupD2.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
            groupD3.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey

        }else if (selectedSpecies.equalsIgnoreCase("กระต่าย")){
            for (Node btn: groupA.getChildren()) {
                btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
            }
            for (Node btn: groupB.getChildren()) {
                btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
            }
            for (Node btn: groupC.getChildren()) {
                btn.setStyle("-fx-background-color: #b7b7b7;"); //grey
            }
            groupE1.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
            groupE2.getChildren().get(0).setStyle("-fx-background-color: #b4e5b5;"); //green
            groupD1.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
            groupD2.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
            groupD3.getChildren().get(0).setStyle("-fx-background-color: #b7b7b7;"); //grey
        }
    }
}
