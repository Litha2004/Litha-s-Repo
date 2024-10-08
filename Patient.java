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

public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // Full constructor
    public Patient(String firstName, String middleName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Other methods like accessors and toString method
    public String toString() {
        return "Name: " + firstName + " " + middleName + " " + lastName + "\n" +
               "Address: " + address + ", " + city + ", " + state + " " + zipCode + "\n" +
               "Phone: " + phoneNumber + "\n" +
               "Emergency Contact: " + emergencyContactName + " (" + emergencyContactPhone + ")";
    }
}