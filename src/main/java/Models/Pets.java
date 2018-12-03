package Models;

public class Pets {
    private String name;
    private String sex;
    private int age;
    private int id;
    private String breed;
    private String disease;
    private String allergy;
    private String species;

    public Pets(int id, String name, String sex, int age, String breed, String disease, String allergy, String species){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.breed = breed;
        this.disease = disease;
        this.allergy = allergy;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getDisease() {
        return disease;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }
    public String getAllergy() {
        return allergy;
    }
    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
}