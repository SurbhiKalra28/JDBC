package com.healthcaremanagement.model;

public class Appointment {
    int appointmentId;
    int patientId;
    int doctorId;
    String appointmentDate;
    String notes;

  public Appointment(){

  }
    public Appointment(int appointmentId, int patientId, int doctorId, String appointmentDate, String notes) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.notes = notes;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Appointment Details: " + "" +
                " appointment ID =" + appointmentId + "\' " +
                "Patient= "+patientId +'\''+
                "doctorId= "+ doctorId +'\''+
                "appointmentDate= "+appointmentDate +'\''+
                "notes= "+notes;
    }
}
