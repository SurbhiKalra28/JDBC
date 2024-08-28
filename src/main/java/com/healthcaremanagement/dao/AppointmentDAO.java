package com.healthcaremanagement.dao;

import com.healthcaremanagement.jdbc.DataBaseConnection;
import com.healthcaremanagement.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public void createAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO Appointments (PatientID, DoctorID,AppointmentDate,Reason) " +
                "VALUES ( ?, ?, ?, ?)";
        try(Connection conn= DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setInt(1,appointment.getPatientId());
            preparedStatement.setInt(2,appointment.getDoctorId());
            preparedStatement.setString(3,appointment.getAppointmentDate());
            preparedStatement.setString(4,appointment.getNotes());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Appointment getAppointmentById(int appointmentId) throws SQLException{
        String query = "SELECT * FROM Appointments WHERE AppointmentID = ?";
        try(Connection conn = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setInt(1,appointmentId);
           try(ResultSet rs = preparedStatement.executeQuery()){
               if(rs.next()){
                   Appointment appointment = new Appointment();
                   appointment.setAppointmentId(rs.getInt("AppointmentID"));
                   appointment.setPatientId(rs.getInt("PatientID"));
                   appointment.setDoctorId(rs.getInt("DoctorID"));
                   appointment.setAppointmentDate(rs.getString("AppointmentDate"));
                   appointment.setNotes(rs.getString("Reason"));
                   return appointment;
               }
           }

        }
        return null;
    }

    public void UpdateAppointment(Appointment appointment) throws SQLException {
        String query = "Update Appointments set AppointmentDate = ?,Reason = ? where AppointmentID = ?";
    try(Connection conn = DataBaseConnection.getConnection();
    PreparedStatement preparedStatement = conn.prepareStatement(query))
    {
        preparedStatement.setString(1,appointment.getAppointmentDate());
        preparedStatement.setString(2,appointment.getNotes());
        preparedStatement.setInt(3,appointment.getAppointmentId());
        preparedStatement.executeUpdate();
    }
    }

    public void deleteAppointment(int appointmentId) throws SQLException {
        String query = "DELETE FROM Appointments WHERE AppointmentID = ?";
        try(Connection conn = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setInt(1,appointmentId);
            preparedStatement.executeUpdate();
        }
    }

    public List<Appointment> getAllAppointments() throws SQLException{
        String query = "SELECT * FROM Appointments";
        List<Appointment> listappointments = new ArrayList<>();
        try(Connection conn = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            try(ResultSet rs = preparedStatement.executeQuery()){
                while(rs.next()){
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentId(rs.getInt("AppointmentID"));
                    appointment.setPatientId(rs.getInt("PatientID"));
                    appointment.setDoctorId(rs.getInt("DoctorID"));
                    appointment.setAppointmentDate(rs.getString("AppointmentDate"));
                    appointment.setNotes(rs.getString("Notes"));
                    listappointments.add(appointment);
                }
            }
            return listappointments;
        }

    }
}
