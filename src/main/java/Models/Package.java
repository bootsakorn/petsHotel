package Models;

public class Package {
    private String name;
    private double price;
    private int shower;
    private int salon;
    private int swim;
    private int walk;

    public Package(String name, double price, int shower, int salon, int swim, int walk){
        this.name = name;
        this.price = price;
        this.shower = shower;
        this.salon = salon;
        this.swim = swim;
        this.walk = walk;
    }

}
