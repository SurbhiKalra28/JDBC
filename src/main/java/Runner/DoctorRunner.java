package Runner;

import com.healthcaremanagement.dao.DoctorDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class DoctorRunner {
    public static void manageDoctors(DoctorDAO doctorDAO, Scanner scanner) throws SQLException{

        int patientId;

        int choice = 6;

      do{

          System.out.println("Please enter Operation ");
          System.out.println("1.Create Doctor");
          System.out.println("2.Update Doctor");
          System.out.println("3.Delete Doctor");
          System.out.println("4.Read Doctor");
          System.out.println("5.Exit");

          choice = scanner.nextInt();
          scanner.nextLine();
          try{
              switch(choice){
                  case 1:
                      com.healthcaremanagement.model.Doctor doctors = new com.healthcaremanagement.model.Doctor();
                      System.out.println("Please enter first name ");
                      doctors.setFirstName(scanner.nextLine());
                      System.out.println("Please enter last name ");
                      doctors.setLastName(scanner.nextLine());
                      System.out.println("Please enter Speciality ");
                      doctors.setSpecialty(scanner.nextLine());
                      System.out.println("Please enter email");
                      doctors.setEmail(scanner.nextLine());
                      System.out.println("Record Created successfully");
                      doctorDAO.createDoctor(doctors);
                      break;
                  case 2:
                      System.out.println("please enter the Doctor ID to be updated ");
                      patientId = scanner.nextInt();
                      scanner.nextLine();
                      com.healthcaremanagement.model.Doctor doctor = doctorDAO.getDoctorById(patientId);
                      if(doctor!= null){
                          System.out.println("Please enter first name ");
                          doctor.setFirstName(scanner.nextLine());
                          System.out.println("Please enter last name ");
                          doctor.setLastName(scanner.nextLine());
                          System.out.println("Please enter Speciality ");
                          doctor.setSpecialty(scanner.nextLine());
                          System.out.println("Please enter email ");
                          doctor.setEmail(scanner.nextLine());
                          doctorDAO.updateDoctor(doctor);
                          System.out.println("Record Updated successfully");
                      }
                      break;

                  case 3:
                      System.out.println("Please enter the Doctor ID to be deleted ");
                      patientId = scanner.nextInt();
                      scanner.nextLine();
                      doctorDAO.deleteDoctor(patientId);
                      System.out.println("Record Deleted successfully");
                      break;
                  case 4:
                      System.out.println("Please enter the Doctor ID to be read ");
                      patientId = scanner.nextInt();
                      scanner.nextLine();
                      com.healthcaremanagement.model.Doctor doctor1 = doctorDAO.getDoctorById(patientId);
                      if(doctor1 != null){
                          System.out.println("Doctor ID : "+doctor1.getDoctorId());
                          System.out.println("Doctor Name : "+doctor1.getFirstName());
                          System.out.println("Doctor Name : "+doctor1.getLastName());
                          System.out.println("Doctor Name : "+doctor1.getSpecialty());
                          System.out.println("Doctor Name : "+doctor1.getEmail());

                      }else{
                          System.out.println("Doctor ID : "+patientId +" not found");
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
