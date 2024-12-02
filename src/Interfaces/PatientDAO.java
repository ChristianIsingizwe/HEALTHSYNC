package Interfaces;

import Entities.Patient;

import java.sql.SQLException;

public interface PatientDAO {
    void savePatient(Patient patient) throws SQLException;
}
