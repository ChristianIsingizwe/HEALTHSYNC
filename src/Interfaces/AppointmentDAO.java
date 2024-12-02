package Interfaces;

import Entities.Appointment;

import java.sql.SQLException;

public interface AppointmentDAO {
    void saveAppointment(Appointment appointment) throws SQLException;
}
