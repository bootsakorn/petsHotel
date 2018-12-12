package Controller;

import Controller.dataController.DataController;
import Models.*;
import Models.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.text.SimpleDateFormat;
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
    @FXML protected TableView reservedNumList;
    @FXML protected TableColumn noCol, dateCol, nameCol;
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
    private Reserve reserve;
    private DataController dataController ;
    private ArrayList<Food> catFoods;
    private ArrayList<Food> dogFoods;
    private ArrayList<Food> rabbitFoods;
    private ArrayList<Customer> customers;
    private ArrayList<Reserve> reserves;
    private ArrayList<ArrayList<String>> petsDetail;
    private ArrayList<Package> packages;
    private SimpleDateFormat sdf;

    public CheckInController(){
        try {
            dataController = new DataController();
            catFoods = dataController.getFoods("แมว");
            dogFoods = dataController.getFoods("สุนัข");
            rabbitFoods = dataController.getFoods("กระต่าย");
            customers = dataController.getCustomer();
            packages = dataController.getPackages();
            reserves = dataController.getReserves();
            petsDetail = new ArrayList();
            sdf = new SimpleDateFormat("dd-MM-yyyy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize(){
        cus = customers.get(0);
        Pets pet1 = cus.getPets().get(0);
        Pets pet2 = cus.getPets().get(1);
        petsDetail.add(new ArrayList(Arrays.asList("2018-12-03",pet1.getName(), "วิสกัส", "Normal Package", "1", "ห้องเดี่ยว","E1")));
        petsDetail.add(new ArrayList(Arrays.asList("2018-12-03",pet2.getName(), "วิสกัส", "Normal Package", "1", "ห้องเดี่ยว","D1")));

        ObservableList<String> list = reservedNumList.getItems();

        for (Reserve r:reserves) {
            list.add(r.getId()+ " " + r.getStart_date() + " " + customers.get(r.getNumber_of_reserve()-1).getFirstName());
        }
        reservedNumList.setItems(list);
    }

    public void handleOnClickSearchBtn(ActionEvent event) {
    }

    public void handleOnClickedGoToCheckInBtn(ActionEvent event){
        mainPane.setVisible(false);
        checkInPane.setVisible(true);
        System.out.println(reservedNumList.getSelectionModel().getSelectedItem());
        String selected = reservedNumList.getSelectionModel().getSelectedItem().toString();
        for (Customer c:customers) {
            if (selected.split(" ")[2].equalsIgnoreCase(c.getFirstName())){
                this.cus = c;
            }
        }
        for (Reserve r: reserves){
            if (selected.split(" ")[0].equalsIgnoreCase(r.getId()+"")){
                this.reserve = r;
            }
        }

        petsDetail = new ArrayList<>();
        petsDetail.add(new ArrayList(Arrays.asList(reserve.getStart_date(),reserve.getPets_id()+"", "วิสกัส", "Normal Package", reserve.getNumber_of_reserve()+"", "ห้องเดี่ยว","E1")));

        String details = "ชื่อลูกค้า : คุณ"+cus.getFirstName()+" "+cus.getLastName()+"\n";
        double price = 0;
        int i = 0;
        for (ArrayList<String> pet:petsDetail) {
            details +=
                    "วันที่จอง : " +pet.get(0)+"\tจำนวนวัน : " + pet.get(4)+"\n"+
                            "ชื่อสัตว์เลี้ยง : " + pet.get(1)+"\n"+
                            "อาหารยี่ห้อ : " + pet.get(2)+"\n"+
                            "แพคเกจ : " + pet.get(3)+"\n"+
                            "ชนิดห้อง : " + pet.get(5)+"\n"+
                            "เลขที่ห้อง : " + pet.get(6)+"\n"+
                            "-------------------------------------------\n";
            price += calculator(pet.get(5),pet.get(3),pet.get(2),cus.getPets().get(i).getSpecies());
            i++;
        }
        allDetails.setText(details);
        totalField.setText(price+"");
    }

    public void handleOnClickedCheckInBtn(ActionEvent event) {
        double recieve = Double.parseDouble(recieveField.getText());
        double total = Double.parseDouble(totalField.getText());
        if (recieve < total){
            //do nothing
        }else{
            changePane.setVisible(true);
            changeField.setText((recieve-total)+"");

        }
    }

    public void handleOnClickedPrintBtn(ActionEvent event) {
        mainPane.setVisible(true);
        checkInPane.setVisible(false);
        changePane.setVisible(false);
    }

    private double calculator(String roomType, String pack, String foodName, String species){
        double total = 0;
        if (roomType.equalsIgnoreCase("ห้องเดี่ยว")){
            total+=100;
        }else if (roomType.equalsIgnoreCase("ห้องรวม")){
            total+=200;
        }
        if (pack.equalsIgnoreCase("Normal Package")){
            total+=packages.get(0).getPrice();
        }else if (pack.equalsIgnoreCase("Silver Package")){
            total+=packages.get(1).getPrice();
        }else if (pack.equalsIgnoreCase("Gold Package")){
            total+=packages.get(2).getPrice();
        }
        if (species.equalsIgnoreCase("แมว")){
            for (Food f:catFoods) {
                if (f.getName().equalsIgnoreCase(foodName)){
                    total+=f.getPrice();
                }
            }
        }else if (species.equalsIgnoreCase("สุนัข")){
            for (Food f:dogFoods) {
                if (f.getName().equalsIgnoreCase(foodName)){
                    total+=f.getPrice();
                }
            }
        }else if (species.equalsIgnoreCase("กระต่าย")){
            for (Food f:rabbitFoods) {
                if (f.getName().equalsIgnoreCase(foodName)){
                    total+=f.getPrice();
                }
            }
        }

        return total;
    }
    @FXML
    public void setData(Customer cus, ArrayList<ArrayList<String>> petsDetail) {
        this.cus = cus;
        this.petsDetail = petsDetail;

        mainPane.setVisible(false);
        checkInPane.setVisible(true);
        String details = "ชื่อลูกค้า : คุณ"+cus.getFirstName()+" "+cus.getLastName()+"\n";
        double price = 0;
        int i = 0;
        for (ArrayList<String> pet:petsDetail) {
            details +=
                    "วันที่จอง : " +pet.get(0)+"\tจำนวนวัน : " + pet.get(4)+"\n"+
                            "ชื่อสัตว์เลี้ยง : " + pet.get(1)+"\n"+
                            "อาหารยี่ห้อ : " + pet.get(2)+"\n"+
                            "แพคเกจ : " + pet.get(3)+"\n"+
                            "ชนิดห้อง : " + pet.get(5)+"\n"+
                            "เลขที่ห้อง : " + pet.get(6)+"\n"+
                            "-------------------------------------------\n";
            price += calculator(pet.get(5),pet.get(3),pet.get(2),cus.getPets().get(i).getSpecies());
            i++;
        }
        allDetails.setText(details);
        totalField.setText(price+"");
    }
}
