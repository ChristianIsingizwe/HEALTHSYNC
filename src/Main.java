import Database.DatabaseManager;
import Interfaces.DoctorDAO;
import Interfaces.AppointmentDAO;
import Services.HospitalService;
import Utils.Logger;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseManager patientDAO = new DatabaseManager();
            DoctorDAO doctorDAO = patientDAO;
            AppointmentDAO appointmentDAO = patientDAO;

            HospitalService hospitalService = new HospitalService(patientDAO, doctorDAO, appointmentDAO);


            hospitalService.run();
        } catch (SQLException e) {
            Logger.logError("Failed to initialize the system: " + e.getMessage());
            System.out.println("Error initializing the hospital management system.");
        }
    }
}
