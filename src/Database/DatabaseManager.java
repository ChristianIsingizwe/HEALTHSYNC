package Database;

import Entities.Appointment;
import Entities.Doctor;
import Entities.Patient;
import Interfaces.AppointmentDAO;
import Interfaces.DoctorDAO;
import Interfaces.PatientDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager implements PatientDAO, DoctorDAO, AppointmentDAO {
    private final Connection connection;

    public DatabaseManager() throws SQLException {
        // Establishing a connection to the database.
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HEALTHSYNC", "root", "");
    }

    /**
     * Saves Patient entity to the database.
     *
     * @param patient Patient object to save
     * @throws SQLException if a database access error occurs
     */

    @Override
    public void savePatient(Patient patient) throws SQLException {
        String query = "INSERT INTO Patient (name, age, ailment) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Use getters to access private fields of Patient
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getAilment());
            stmt.executeUpdate();
        }
    }

    /**
     * Saves Doctor entity to the database.
     *
     * @param doctor the Doctor object to save
     * @throws SQLException if a database access error occurs
     */

    @Override
    public void saveDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO Doctor (name, specialization) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSpecialization());
            stmt.executeUpdate();
        }
    }

    /**
     * Saves an Appointment entity to the database.
     *
     * @param appointment the Appointment object to save
     * @throws SQLException if a database access error occurs
     */

    @Override
    public void saveAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO Appointment (patient_id, doctor_id, date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setString(3, appointment.getDate());
            stmt.executeUpdate();
        }
    }
}
