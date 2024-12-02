package Entities;

public class Doctor {
    private static int counter = 1;
    private final int id;
    private String name;
    private String specialization;

    // A parameterized constructor
    public Doctor(String name, String specialization) {
        this.id = counter++;
        this.name = name;
        this.specialization = specialization;
    }

    // Public getters and setters to get the necessary fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Overriding the toString method in order to print the doctor in the way we want
    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + ", Specialization=" + specialization + "]";
    }
}

