package Controller;

import Controller.dataController.DataController;
import Models.Customer;
import Models.Package;
import Models.Pets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckInController extends CounterPageController{

    @FXML protected MenuItem home;
    @FXML protected MenuItem calendar;
    @FXML protected MenuItem logout;
    @FXML protected Button counterBtn;
    @FXML protected Button paperBtn;
    @FXML protected Button salonBtn;
    @FXML protected Button serviceBtn;
    @FXML protected Button stockBtn;
    // pane
    @FXML protected AnchorPane mainPane;
    @FXML protected AnchorPane checkInPane;
    @FXML protected AnchorPane changePane;
    // main pane
    @FXML protected TextField searchTextField;
    @FXML protected Button searchBtn;
    @FXML protected ListView reservedNumList;
    @FXML protected Button goToCheckInBtn;
    // check in pane
    @FXML protected TextArea allDetails;
    @FXML protected TextField totalField;
    @FXML protected TextField recieveField;
    @FXML protected Button checkInBtn;
    // change pane
    @FXML protected TextField changeField;
    @FXML protected Button printBtn;
    // use in class
    private Customer cus;
    private Package pack;
    private DataController dataController ;
    private ArrayList<Pets> pets = dataController.getPets();
    private ArrayList<Customer> customers = dataController.getCustomer();
    private ArrayList<ArrayList<String>> petsDetail = new ArrayList();
    private ArrayList<Package> packages = dataController.getPackages();

    public CheckInController(){
        try {
            dataController = new DataController();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize(){
//        cus = new Customer(001,"ศศิธร", "สายพา", "88/131");
//        cus.addPets(new Pets(001,"น้องโตโต้","ตัวผู้",2,"ไซบีเรีย","-","-","สุนัข"));
//        cus.addPets(new Pets(002,"น้องปอย","ตัวเมีย",2,"เปอร์เซีย","-","-","แมว"));
//        cus.addPets(new Pets(003,"น้องโอ๋เอ๋","ตัวผู้",1,"แคระ","-","-","กระต่าย"));
        petsDetail.add(new ArrayList(Arrays.asList("2018-12-03","น้องโตโต้", "วิสกัส", "Normal Package", "1", "ห้องเดี่ยว","E1")));
        petsDetail.add(new ArrayList(Arrays.asList("2018-12-03","น้องปอย", "วิสกัส", "Normal Package", "1", "ห้องเดี่ยว","D1")));
        cus = customers.get(0);

        settingMainPage();
    }

    public void handleOnClickSearchBtn(ActionEvent event) {
    }

    public void handleOnClickedGoToCheckInBtn(ActionEvent event){
        mainPane.setVisible(false);
        checkInPane.setVisible(true);

        String details = "ชื่อลูกค้า : คุณ"+cus.getFirstName()+" "+cus.getLastName()+"\n";
        for (ArrayList<String> pet:petsDetail) {
            details +=
                    "วันที่จอง : " +pet.get(0)+"\tจำนวนวัน : " + pet.get(4)+"\n"+
                            "ชื่อสัตว์เลี้ยง : " + pet.get(1)+"\n"+
                            "อาหารยี่ห้อ : " + pet.get(2)+"\n"+
                            "แพคเกจ : " + pet.get(3)+"\n"+
                            "ชนิดห้อง : " + pet.get(5)+"\n"+
                            "เลขที่ห้อง : " + pet.get(6)+"\n"+
                            "-------------------------------------------\n";
        }
        allDetails.setText(details);
        totalField.setText("300");
    }

    public void handleOnClickedCheckInBtn(ActionEvent event) {
        double recieve = Double.parseDouble(recieveField.getText());
        double total = Double.parseDouble(totalField.getText());
        if (recieve < total){
            //do nothing
        }else{
            changePane.setVisible(true);
            changeField.setText(calculator(total,recieve)+"");
        }

    }

    public void handleOnClickedPrintBtn(ActionEvent event) {
    }

    private void settingMainPage(){
        ObservableList<String> cus = reservedNumList.getItems();
        for (Customer c:customers) {
            cus.add(c.getId() + " " + c.getFirstName() + " " + c.getLastName());
        }
    }

    private double calculator(double total, double recieve){
        return recieve-total;
    }

}
