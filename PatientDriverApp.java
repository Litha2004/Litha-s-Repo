/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 10/08/2024
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Lithalethu Mkunqwana__________
*/

import java.util.Scanner;

public class PatientDriverApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Collecting patient information
        System.out.println("Enter patient first name:");
        String firstName = input.nextLine();
        System.out.println("Enter patient middle name:");
        String middleName = input.nextLine();
        System.out.println("Enter patient last name:");
        String lastName = input.nextLine();
        
        System.out.println("Enter patient street address:");
        String address = input.nextLine();
        System.out.println("Enter patient city:");
        String city = input.nextLine();
        System.out.println("Enter patient state:");
        String state = input.nextLine();
        System.out.println("Enter patient ZIP code:");
        String zipCode = input.nextLine();

        System.out.println("Enter patient phone number:");
        String phoneNumber = input.nextLine();

        System.out.println("Enter emergency contact name:");
        String emergencyContactName = input.nextLine();
        System.out.println("Enter emergency contact phone number:");
        String emergencyContactPhone = input.nextLine();

        // Creating Patient object with full information
        Patient patient = new Patient(firstName, middleName, lastName, address, city, state, zipCode, phoneNumber, emergencyContactName, emergencyContactPhone);

        // Creating three Procedure objects
        Procedure procedure1 = new Procedure("X-Ray", "06/12/2023", "Dr. Smith", 500.0);
        Procedure procedure2 = new Procedure("Blood Test", "06/13/2023", "Dr. Jones", 300.0);
        Procedure procedure3 = new Procedure("MRI", "06/14/2023", "Dr. Adams", 1200.0);

        // Displaying patient and procedure information
        displayPatient(patient);
        System.out.println();

        displayProcedure(procedure1);
        System.out.println();
        displayProcedure(procedure2);
        System.out.println();
        displayProcedure(procedure3);
        System.out.println();

        // Calculating and displaying total charges
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.printf("Total Charges: $%.2f\n", totalCharges);
    }

    // Method to display patient's information
    public static void displayPatient(Patient patient) {
        System.out.println("Patient Information:");
        System.out.println(patient.toString());
    }

    // Method to display procedure's information
    public static void displayProcedure(Procedure procedure) {
        System.out.println("Procedure Information:");
        System.out.println(procedure.toString());
    }

    // Method to calculate total charges for three procedures
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getProcedureCharges() + p2.getProcedureCharges() + p3.getProcedureCharges();
    }
}