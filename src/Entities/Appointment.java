package Entities;

public class Appointment {
    private static int counter = 1;
    private final int id;
    private final int patientId;
    private final int doctorId;
    private String date;

    // Parameterized constructor
    public Appointment(int patientId, int doctorId, String date) {
        this.id = counter++;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    // Getters and setters for encapsulated fields
    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    // Overriding the toString method
    @Override
    public String toString() {
        return "Appointment [ID=" + id + ", Patient ID=" + patientId + ", Doctor ID=" + doctorId + ", Date=" + date + "]";
    }
}

