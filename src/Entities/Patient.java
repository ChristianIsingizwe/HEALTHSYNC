package Entities;

public class Patient {
    private static int counter = 1;
    private final int id;
    private String name;
    private int age;
    private String ailment;

    // Parameterized constructor
    public Patient(String name, int age, String ailment) {
        this.id = counter++;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }

    // Getters and setters for encapsulated fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }


    // Overriding the toString method
    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Age=" + age + ", Ailment=" + ailment + "]";
    }
}
