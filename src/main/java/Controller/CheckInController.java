package Controller;

import Controller.dataController.DataController;
import Models.*;
import Models.Package;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;

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
    private Reserve reserve;
    private DataController dataController ;
    private ArrayList<Food> catFoods;
    private ArrayList<Food> dogFoods;
    private ArrayList<Food> rabbitFoods;
    private ArrayList<Customer> customers;
    private ArrayList<Reserve> reserves;
    private ArrayList<ArrayList<String>> petsDetail;
    private ArrayList<Package> packages;

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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize(){
        dataController.getData();
        ObservableList<CheckInDataForTableView> list = reservedNumList.getItems();
        noCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        for (Reserve r:reserves) {
            if (!dataController.getCheckInByResereveId(r.getId()).isStatus()) {
                CheckInDataForTableView item = new CheckInDataForTableView(
                        r.getId(),
                        r.getStart_date(),
                        dataController.getCustomerById(r.getCustomer_id()).getFirstName()
                );
                list.add(item);
            }
        }
        reservedNumList.setItems(list);
    }

    public void handleOnClickSearchBtn(ActionEvent event) {
    }

    public void handleOnClickedGoToCheckInBtn(ActionEvent event){
        mainPane.setVisible(false);
        checkInPane.setVisible(true);
        CheckInDataForTableView selected = (CheckInDataForTableView) reservedNumList.getSelectionModel().getSelectedItem();
        System.out.println(selected.getFirstName());
        for (Customer c:customers) {
            if (selected.getFirstName().equalsIgnoreCase(c.getFirstName())){
                this.cus = c;
            }
        }
        for (Reserve r: reserves){
            if (selected.getId() == r.getId()){
                this.reserve = r;
            }
        }

        System.out.println(reserve.getList().size());

        String details = "ชื่อลูกค้า : คุณ"+cus.getFirstName()+" "+cus.getLastName()+"\n";
        double price = 0;
        for (TakingCarePetsList tk : reserve.getList()){
            details +=
                    "วันที่จอง : " +reserve.getStart_date()+"\tจำนวนวัน : " + reserve.getNumber_of_reserve()+"\n"+
                            "ชื่อสัตว์เลี้ยง : " + dataController.getPetById(tk.getPetId()).getName()+"\n"+
                            "อาหารยี่ห้อ : " + dataController.getFoodById(tk.getFoodId()).getName()+"\n"+
                            "แพคเกจ : " + dataController.getPackageById(tk.getPackageId()).getName()+"\n"+
                            "ชนิดห้อง : " + dataController.getRoomById(tk.getRoomId()).getType()+"\n"+
                            "เลขที่ห้อง : " + dataController.getRoomById(tk.getRoomId()).getName().toUpperCase()+"\n"+
                            "-------------------------------------------\n";
            price += calculator(dataController.getRoomById(tk.getRoomId()).getType(),
                    dataController.getPackageById(tk.getPackageId()).getName(),
                    dataController.getFoodById(tk.getFoodId()).getName(),
                    dataController.getPetById(tk.getPetId()).getSpecies());
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
            dataController.checkin(reserve.getId(), total, recieve);
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
