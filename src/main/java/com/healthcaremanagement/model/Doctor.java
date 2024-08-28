package com.healthcaremanagement.model;

public class Doctor {
    int doctorId;
    String firstName;
    String lastName;
    String specialty;
    String email;

    public Doctor(){}
    public Doctor(int doctorId, String firstName, String lastName, String specialty, String email){
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.email = email;
    }
    public int getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getEmail() {
        return email;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient [" +
                "doctorId=" + doctorId + '\'' +
                "firstName=" + firstName+'\'' +
                "lastName=" + lastName+'\'' +
                "speciality= "+specialty+'\'' +
                "gmail="+email+']';
    }
}
