package Runner;

import com.healthcaremanagement.dao.AppointmentDAO;
import com.healthcaremanagement.model.Appointment;

import java.sql.SQLException;
import java.util.Scanner;

public class AppointmentRunner {

        public static void manageAppointment(AppointmentDAO appointmentDAO, Scanner scanner) throws SQLException {

        int choice = 6;

        do{

            System.out.println("Please enter Operation ");
            System.out.println("1.Create Appointment");
            System.out.println("2.Update Appointment");
            System.out.println("3.Delete Appointment");
            System.out.println("4.Read Appointment");
            System.out.println("5.Exit");

            choice = scanner.nextInt();
            scanner.nextLine();
            try{
                switch(choice){
                    case 1:
                        Appointment appointment= new Appointment();
                        System.out.println("Please enter PatientID ");
                        appointment.setPatientId(scanner.nextInt());
                        System.out.println("Please enter DoctorID");
                        appointment.setDoctorId(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Please enter appointmentDate ");
                        appointment.setAppointmentDate(scanner.nextLine());
                        System.out.println("Please enter Notes");
                        appointment.setNotes(scanner.nextLine());
                        System.out.println("Record Created successfully");
                        appointmentDAO.createAppointment(appointment);
                        break;
                    case 2:
                        System.out.println("please enter the Appointment ID to be updated ");
                        int appointmentID = scanner.nextInt();
                        scanner.nextLine();
                        Appointment appointment1 = new Appointment();
                        appointment1 = appointmentDAO.getAppointmentById(appointmentID);
                        if(appointment1!= null){
                            System.out.println("Please Appointment Date ");
                            appointment1.setAppointmentDate(scanner.nextLine());
                            System.out.println("Please enter Notes ");
                            appointment1.setNotes(scanner.nextLine());
                            appointmentDAO.UpdateAppointment(appointment1);
                            System.out.println("Record Updated successfully");
                        }
                        break;

                    case 3:
                        System.out.println("Please enter the Appointment ID to be deleted ");
                        int appointmentIDToDelete = scanner.nextInt();
                        scanner.nextLine();
                        appointmentDAO.deleteAppointment(appointmentIDToDelete);
                        System.out.println("Record Deleted successfully");
                        break;
                    case 4:
                        Appointment appointment2 = new Appointment();
                        System.out.println("Please enter the Appointment ID to be read ");
                        int appointmentIDToRead = scanner.nextInt();
                        scanner.nextLine();
                        appointment2 = appointmentDAO.getAppointmentById(appointmentIDToRead);
                        if(appointment2 != null){
                            System.out.println("Appointment ID : "+appointment2.getAppointmentId());
                            System.out.println("Appointment Patient ID : "+appointment2.getPatientId());
                            System.out.println("Appointment Doctor ID : "+appointment2.getDoctorId());
                            System.out.println("Appointment Date : "+appointment2.getAppointmentDate());
                            System.out.println("Notes : "+appointment2.getNotes());

                        }else{
                            System.out.println("Appointment ID : "+appointmentIDToRead +" not found");
                        }
                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                }


            }catch (SQLException e){
                e.printStackTrace();
            }


        }while(choice != 5);

    }
    }

