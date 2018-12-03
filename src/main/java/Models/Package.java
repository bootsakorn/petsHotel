package Models;

public class Package {
    private int id;
    private String name;
    private double price;
    private int shower;
    private int salon;
    private int swim;
    private int walk;

    public Package(int id, String name, double price, int shower, int salon, int swim, int walk){
        this.name = name;
        this.id = id;
        this.price = price;
        this.shower = shower;
        this.salon = salon;
        this.swim = swim;
        this.walk = walk;
    }

}
