import Runner.AppointmentRunner;
import Runner.DoctorRunner;
import Runner.PatientRunner;
import com.healthcaremanagement.dao.AppointmentDAO;
import com.healthcaremanagement.dao.DoctorDAO;
import com.healthcaremanagement.dao.PatientDAO;
import com.healthcaremanagement.model.Patient;

import java.sql.SQLException;
import java.util.Scanner;

public class HealthcareManagementApp {
    public static void main(String[] args) {

int option = 5;
        try(Scanner sc= new Scanner(System.in)){

            do{
                System.out.println("Enter an option: ");
                System.out.println("--- MAIN MENU ---");
                System.out.println("1. Manage Patients");
                System.out.println("2. Manage Doctors");
                System.out.println("3. Manage Appointments");
                System.out.println("4. Exit");
                 option = sc.nextInt();
                switch(option){
                    case 1:
                        PatientDAO patientDAO = new PatientDAO();
                        PatientRunner.managePatients(patientDAO,sc);
                        break;
case 2:
    DoctorDAO doctorDAO = new DoctorDAO();
    DoctorRunner.manageDoctors(doctorDAO,sc);
    break;
    case 3:
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        AppointmentRunner.manageAppointment(appointmentDAO,sc);
        break;
        default:
            System.out.println("Invalid Choice!");
            break;
                }
            }while(option != 4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
