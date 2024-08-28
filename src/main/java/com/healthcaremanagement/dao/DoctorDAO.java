package com.healthcaremanagement.dao;

import com.healthcaremanagement.jdbc.DataBaseConnection;
import com.healthcaremanagement.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void createDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO Doctors(FirstName,LastName,Specialization,Email)" +
                "VALUES(?,?,?,?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preStm = conn.prepareStatement(query)) {
            preStm.setString(1, doctor.getFirstName());
            preStm.setString(2, doctor.getLastName());
            preStm.setString(3, doctor.getSpecialty());
            preStm.setString(4, doctor.getEmail());
            preStm.executeUpdate();
        }
    }

    public Doctor getDoctorById(int DoctorID) throws SQLException {
        String query = "Select * from Doctors where DoctorID=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pStm = conn.prepareStatement(query)) {
            pStm.setInt(1, DoctorID);

            try (ResultSet rs = pStm.executeQuery()) {
                if (rs.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setDoctorId(rs.getInt("DoctorID"));
                    doctor.setFirstName(rs.getString("FirstName"));
                    doctor.setLastName(rs.getString("LastName"));
                    doctor.setSpecialty(rs.getString("Specialization"));
                    doctor.setEmail(rs.getString("Email"));
                    return doctor;
                }
            }
        }

        return null;
    }

    public void updateDoctor(Doctor doctor) throws SQLException {
        String query = "Update Doctors SET FirstName =? ,LastName = ?,Specialization =? ,Email =? WHERE DoctorID=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pStm = conn.prepareStatement(query)) {
            pStm.setString(1, doctor.getFirstName());
            pStm.setString(2, doctor.getLastName());
            pStm.setString(3, doctor.getSpecialty());
            pStm.setString(4, doctor.getEmail());
            pStm.setInt(5, doctor.getDoctorId());
            pStm.executeUpdate();
        }
    }

    public void deleteDoctor(int DoctorID) throws SQLException {
        String query = "Delete from Doctors where DoctorID=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pStm = conn.prepareStatement(query)) {
            pStm.setInt(1, DoctorID);
            pStm.executeUpdate();
        }
    }

    public List<Doctor> getAllDoctors() throws SQLException {
String query ="Select * from Doctors";
List<Doctor> doctors = new ArrayList<>();
try (Connection conn = DataBaseConnection.getConnection();
PreparedStatement pStm = conn.prepareStatement(query);
ResultSet rs = pStm.executeQuery()) {
while(rs.next()){
    Doctor doctor = new Doctor();
    doctor.setDoctorId(rs.getInt("DoctorID"));
    doctor.setFirstName(rs.getString("FirstName"));
    doctor.setLastName(rs.getString("LastName"));
    doctor.setSpecialty(rs.getString("Specialization"));
    doctor.setEmail(rs.getString("Email"));
    doctors.add(doctor);


}
    }
return null;
}


}