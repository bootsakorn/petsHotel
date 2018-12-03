package Models;

public class Employee {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private double salary;
    private int age;
    private String sex;
    private String education;
    private String position;

    public Employee(int id, String username, String password, String firstName, String lastName, String address, double salary, int
                    age, String sex, String education, String position){
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.education = education;
        this.position = position;
    }


}
