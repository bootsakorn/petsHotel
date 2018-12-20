package Controller.dataController;

import Models.*;
import Models.Package;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataController {
    /*
    Controllers
     */
    private AppointmentBillDataController appointmentBillDataController;
    private CheckInDataController checkInDataController;
    private CheckoutDataController checkoutDataController;
    private CustomersDataController customersDataController;
    private FoodDataController foodDataController;
    private LoginDataController loginDataController;
    private PackageDataController packageDataController;
    private PetsListDataController petsListDataController;
    private PetsDataController petsDataController;
    private ReceiptDataController receiptDataController;
    private ReserveDataController reserveDataController;
    private RoomDataController roomDataController;
    private SpeciesDataController speciesDataController;;
    private StorageDataController storageDataController;
    private TakingCarePetsListDataController takingCarePetsListDataController;
    private ServiceDataController serviceDataController;
    private SalonDataController salonDataController;

    /*
    Models
     */
    private ArrayList<Appliance> appliances;
    private ApplianceStorage applianceStorage;
    private ArrayList<AppointmentBill> appointmentBills;
    private ArrayList<CheckIn> checkIns;
    private ArrayList<CheckOut> checkOuts;
    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;
    private ArrayList<Food> foods;
    private FoodStorage foodStorage;
    private ArrayList<Package> packages;
    private ArrayList<Pets> pets;
    private ArrayList<PetsList> petsLists;
    private ArrayList<Receipt> receipts;
    private ArrayList<Reserve> reserves;
    private ArrayList<Room> rooms;
    private ArrayList<TakingCarePetsList> takingCarePetsLists;
    private ArrayList<Salon> salons;
    private ArrayList<Service> services;
    public DataController() throws ClassNotFoundException {
        this.appointmentBillDataController = new AppointmentBillDataController();
        this.checkInDataController = new CheckInDataController();
        this.checkoutDataController = new CheckoutDataController();
        this.customersDataController = new CustomersDataController();
        this.foodDataController = new FoodDataController();
        this.loginDataController = new LoginDataController();
        this.packageDataController = new PackageDataController();
        this.petsDataController = new PetsDataController();
        this.petsListDataController = new PetsListDataController();
        this.receiptDataController = new ReceiptDataController();
        this.reserveDataController = new ReserveDataController();
        this.roomDataController = new RoomDataController();
        this.speciesDataController = new SpeciesDataController();
        this.storageDataController = new StorageDataController();
        this.takingCarePetsListDataController = new TakingCarePetsListDataController();
        this.salonDataController = new SalonDataController();
        this.serviceDataController = new ServiceDataController();
        this.getData();
    }

    public void getData() {
        this.pets = petsDataController.getPetsList();
        this.checkIns = checkInDataController.getCheckInList();
        this.petsLists = petsListDataController.getPetsIdList();
        this.customers = customersDataController.getCustomers();
        this.foods = foodDataController.getFoods();
        this.packages = packageDataController.getPackage();
        this.takingCarePetsLists = takingCarePetsListDataController.getTakingCarePetsList();
        this.reserves = reserveDataController.getReserve();
        this.rooms = roomDataController.getRooms();
        this.appointmentBills = appointmentBillDataController.getAppointmentBills();
        this.salons = salonDataController.getSalons();
        this.services = serviceDataController.getServices();
    }

    public String getPassword (String username){
        return loginDataController.getPassword(username);

    }

    public ArrayList<Customer> getCustomer () {
        for (PetsList petsList: petsLists){
            for (Customer c : customers){
                if (petsList.getCustomerId() == c.getId()){
                    for (Pets pet : pets){
                        if (petsList.getPetId()==pet.getId()){
                            c.addPets(pet);
                        }
                    }
                }
            }
        }
        return customers;
    }

    public void insertNewCustomer (String firstname, String lastname, String address,String pname,int age,String sex, String breed, String disease, String allergy, String species){
        customersDataController.insertCustomer(firstname, lastname, address);
        petsDataController.insertPet(pname, age, sex, breed, disease, allergy, speciesDataController.convertSpeciesNameToId(species));
        getData();
        int pId = pets.get(pets.size()-1).getId();
        int cId = customers.get(customers.size()-1).getId();
        petsListDataController.insertPetsList(pId, cId);
        getData();
    }

    public ArrayList<Food> getFoods (String species){
        ArrayList<Food> foodOfSpecies = new ArrayList<>();
        for (Food food : foods){
            if (food.getSpecies().equalsIgnoreCase(species)){
                foodOfSpecies.add(food);
            }
        }
        return foodOfSpecies;
    }

    public int getFoodId (String food) {
        for (Food f : foods){
            if (f.getName().equals(food)){
                return f.getId();
            }
        }
        return 1;
    }

    public ArrayList<Package> getPackages (){
        return packages;
    }

    public int getPackageId (String packageName) {
        for (Package p : packages) {
            if (p.getName().equalsIgnoreCase(packageName)){
                return p.getId();
            }
        }
        return Integer.parseInt(null);
    }

    public int getIdTakingCarePetsListNext(){
        int id;
        if ( 0 == takingCarePetsListDataController.getMaxId()) {
            id = 0;
        } else {
            id = takingCarePetsListDataController.getMaxId()+1;
        }
        return id;
    }

    public void insertReserve (String reserveDate, String startDate, int numberOfReserve, int customerId, ArrayList<TakingCarePetsList> takingCarePetsListsParam) {
        int takingCarePetsId = takingCarePetsListsParam.get(0).getId();
        String[] strtDateSplit = startDate.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(strtDateSplit[0]), Integer.valueOf(strtDateSplit[1]), Integer.valueOf(strtDateSplit[2]));
        LocalDate endLocalDate = localDate.plusDays(numberOfReserve);
        String strtDate = localDate.getDayOfMonth()+"-"+localDate.getMonthValue()+"-"+localDate.getYear();
        String endDate = endLocalDate.getDayOfMonth()+"-"+endLocalDate.getMonthValue()+"-"+localDate.getYear();
        reserveDataController.insertReserve(reserveDate, strtDate, numberOfReserve, customerId, takingCarePetsId);
        for (TakingCarePetsList t: takingCarePetsListsParam) {
            int id = t.getId();
            int customer_id = t.getCustomerId();
            int pet_id = t.getPetId();
            int packageId = t.getPackageId();
            int foodId = t.getFoodId();
            int room_id = t.getRoomId();
            takingCarePetsListDataController.insertTakingCarePetsList(id, customer_id, pet_id, packageId, foodId, room_id);
        }
        appointmentBillDataController.insertAppointmentBill(endDate, takingCarePetsId);
        this.getData();
        int reserveId = reserves.get(reserves.size()-1).getId();
        int appId = appointmentBills.get(appointmentBills.size()-1).getId();
        int recieptId = 0;
        checkInDataController.insertCheckin(strtDate, reserveId, appId, recieptId, 0);
        checkoutDataController.insertCheckout(endDate, appointmentBills.get(appointmentBills.size()-1).getId(), "", 0);
        getData();
    }

    public ArrayList<Reserve> getReserves (){
        return reserves;
    }

    public Reserve getReserve (int customerId){
        for (Reserve r : reserves){
            if (r.getCustomer_id() == customerId){
                return r;
            }
        }
        return null;
    }

    public ArrayList<TakingCarePetsList> getTakingCarePetsLists (int id) {
        ArrayList<TakingCarePetsList> tCPLists = new ArrayList<>();
        for (TakingCarePetsList t : takingCarePetsLists){
            if (t.getId() == id) {
                tCPLists.add(t);
            }
        }
        return tCPLists;
    }

    private void setTotalPrice (double totalPrice){

    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public int getRoomId (String name) {
        System.out.println(rooms.size());
        for (Room r : rooms){
            if (r.getName().equalsIgnoreCase(name)){
                return r.getId();
            }
        }
        return Integer.parseInt(null);
    }

    public ArrayList<Pets> getPets() {
        for (Pets p : this.pets){
            System.out.print(p.getId());
        }
        return this.pets;
    }

    public Pets getPet(String name){
        for (Pets p : pets){
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public Pets getPetById(int id){
        for (Pets p : pets){
            if (p.getId() == (id)){
                return p;
            }
        }
        return null;
    }

    public Package getPackageById(int id){
        for (Package p : packages){
            if (p.getId() == (id)){
                return p;
            }
        }
        return null;
    }

    public Room getRoomById(int id){
        for (Room r : rooms){
            if (r.getId() == (id)){
                return r;
            }
        }
        return null;
    }

    public Food getFoodById(int id){
        for (Food f : foods){
            if (f.getId() == (id)){
                return f;
            }
        }
        return null;
    }

    public Customer getCustomerById(int id){
        for (Customer p : customers){
            if (p.getId() == (id)){
                return p;
            }
        }
        return null;
    }

    public ArrayList<AppointmentBill> getAppointmentBills() {
        return appointmentBills;
    }

    public void checkin (int reserveId, double total, double receive){

        for (int i=0; i<reserves.size(); i++){
            if (reserves.get(i).getId() == reserveId) {
                reserves.get(i).setTotal_price(total);
                break;
            }
        }

        for (int j=0; j<checkIns.size(); j++){
            if (checkIns.get(j).getReserve_id() == reserveId){
                checkInDataController.editStatus(checkIns.get(j).getId(), 1);
                String date = checkIns.get(j).getDate();
                receiptDataController.insertReceipt(date, checkIns.get(j).getId(), total, receive, receive-total);
                break;
            }
        }

        LocalDate localDate = LocalDate.now();
        String date = localDate.getDayOfMonth()+"-"+localDate.getMonthValue()+"-"+localDate.getYear();
        int tklId = 0;
        for (Reserve r : reserves){
            if (r.getId() == reserveId){
                tklId = r.getId();
                break;
            }
        }
        if (tklId > 0) {
            for (TakingCarePetsList t : takingCarePetsLists){
                if (t.getId() == tklId){
                    String petName = "";
                    String roomName = "";
                    String foodName = "";
                    int shower = 0;
                    int salon = 0;
                    int walk = 0;
                    int swim = 0;
                    for (Pets p : pets) {
                        if (p.getId() == t.getPetId()){
                            petName = p.getName();
                            break;
                        }
                    }
                    for (Room r : rooms){
                        if(r.getId() == t.getRoomId()){
                            roomName = r.getName();
                            break;
                        }
                    }
                    for (Food f : foods){
                        if(f.getId() == t.getFoodId()){
                            foodName = f.getName();
                            break;
                        }
                    }
                    for (Package p : packages){
                        if (p.getId() == t.getPackageId()){
                            shower = p.getShower();
                            salon = p.getSalon();
                            walk = p.getWalk();
                            swim = p.getSwim();
                        }
                    }
                    if (salon == 1) {
                        salonDataController.insertSalon(petName, roomName, 0, "ตัดขน", date);
                    }
                    if (shower == 1) {
                        salonDataController.insertSalon(petName, roomName, 0, "อาบน้ำ", date);
                    }
                    if (walk == 1) {
                        serviceDataController.insertService(petName, roomName, 0, "เดินเล่น", date);
                    }
                    if (swim == 1) {
                        serviceDataController.insertService(petName, roomName, 0, "ว่ายน้ำ", date);
                    }
                    serviceDataController.insertService(petName, roomName, 0, "ให้อาหาร"+foodName, date);

                }
            }
        }
        getData();
    }

    public void checkout (int appId){
        for (int i=0; i<checkOuts.size(); i++){
            if (checkOuts.get(i).getAppointment_bill_id() == appId){
                checkoutDataController.editStatus(checkIns.get(i).getId(), 1);
                break;
            }
        }
        getData();
    }

    public CheckIn getCheckInByResereveId(int id){
        for (CheckIn c : checkIns){
            if (c.getReserve_id() == id){
                return c;
            }
        }
        return null;
    }

    public AppointmentBill getAppbillById(int id){
        for (AppointmentBill bill : appointmentBills){
            if (bill.getId() == id){
                return bill;
            }
        }
        return null;
    }

    public TakingCarePetsList getTKCListById(int cusid){
        for (TakingCarePetsList tk : takingCarePetsLists){
            if (tk.getCustomerId() == cusid){
                return tk;
            }
        }
        return null;
    }

    public Reserve getReserveById(int id){
        for (Reserve r : reserves){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    public ArrayList<CheckIn> getCheckIns() {
        return checkIns;
    }

    public ArrayList<Salon> getSalon (){
        return salons;
    }

    public Salon getSalon(int salon_id){
        Salon salon = new Salon(0, "", "", "", true, "");
        for (Salon s: salons){
            if (s.getId() == salon_id){
                salon = s;
            }
        }
        return salon;
    }

    public ArrayList<Service> getService (){
        return services;
    }

    public Service getService(int service_id){
        Service service = new Service(0, "", "", "", true, "");
        for (Service s: services){
            if (s.getId() == service_id){
                service = s;
            }
        }
        return service;
    }

    public void editStatusSalon (int salon_id) {
        salonDataController.editStatus(salon_id, 1);
        getData();
    }

    public void editStatusService (int service_id) {
        serviceDataController.editStatus(service_id, 1);
        getData();
    }
}

