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
public class Procedure {
    private String procedureName;
    private String procedureDate;
    private String practitioner;
    private double procedureCharges;

    // Full constructor
    public Procedure(String procedureName, String procedureDate, String practitioner, double procedureCharges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitioner = practitioner;
        this.procedureCharges = procedureCharges;
    }

    // Getters for attributes
    public double getProcedureCharges() {
        return procedureCharges;
    }

    // toString method to display Procedure info
    public String toString() {
        return "Procedure: " + procedureName + "\n" +
               "Date: " + procedureDate + "\n" +
               "Practitioner: " + practitioner + "\n" +
               "Charges: $" + procedureCharges;
    }
}