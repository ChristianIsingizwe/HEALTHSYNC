package Interfaces;

import Entities.Doctor;

import java.sql.SQLException;

public interface DoctorDAO {
    void saveDoctor(Doctor doctor) throws SQLException;
}
