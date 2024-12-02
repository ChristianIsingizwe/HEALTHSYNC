package Services;

import Database.DatabaseManager;
import Entities.Appointment;
import Entities.Doctor;
import Entities.Patient;
import Utils.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalService {
    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private final DatabaseManager dbManager;

    public HospitalService() {
        DatabaseManager tempDbManager = null;
        try {
            tempDbManager = new DatabaseManager();
        } catch (SQLException e) {
            Logger.logError("Failed to initialize Database.DatabaseManager: " + e.getMessage());
            System.out.println("Critical error initializing database connection. Exiting.");
            System.exit(1);
        }
        dbManager = tempDbManager;
    }

    /**
     * Main application loop for managing the hospital system.
     */
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                int choice = getChoice(scanner);

                switch (choice) {
                    case 1 -> addPatient(scanner);
                    case 2 -> addDoctor(scanner);
                    case 3 -> scheduleAppointment(scanner);
                    case 4 -> displayPatients();
                    case 5 -> displayDoctors();
                    case 6 -> displayAppointments();
                    case 7 -> {
                        System.out.println("Exiting the system. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            Logger.logError(e.getMessage());
        }
    }

    /**
     * Displays the main menu options.
     */
    private void displayMenu() {
        System.out.println("\n=== Hospital Management System ===");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. Schedule Appointment");
        System.out.println("4. Display All Patients");
        System.out.println("5. Display All Doctors");
        System.out.println("6. Display All Appointments");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Reads the user's menu choice.
     */
    private int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return -1;
        }
    }

    private void addPatient(Scanner scanner) {
        System.out.print("Enter Patient's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient's Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Ailment's: ");
        String ailment = scanner.nextLine();

        Patient patient = new Patient(name, age, ailment);
        patients.add(patient);

        try {
            dbManager.savePatient(patient);
            System.out.println("Patient added successfully!");
        } catch (Exception e) {
            Logger.logError(e.getMessage());
        }
    }

    private void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(name, specialization);
        doctors.add(doctor);

        try {
            dbManager.saveDoctor(doctor);
            System.out.println("Doctor added successfully!");
        } catch (Exception e) {
            Logger.logError(e.getMessage());
        }
    }

    private void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Doctor ID: ");
        int doctorId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Appointment appointment = new Appointment(patientId, doctorId, date);
        appointments.add(appointment);

        try {
            dbManager.saveAppointment(appointment);
            System.out.println("Appointment scheduled successfully!");
        } catch (Exception e) {
            Logger.logError(e.getMessage());
        }
    }

    private void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            patients.forEach(System.out::println);
        }
    }

    private void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            doctors.forEach(System.out::println);
        }
    }

    private void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            appointments.forEach(System.out::println);
        }
    }
}
