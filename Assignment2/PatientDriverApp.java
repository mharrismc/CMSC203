import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: (Give a brief description for each Class)
 * Due: 06/30/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Madison Harris________
*/


/**
	The PatientDriverApp class collects information on a patient and their procedures and
	displays a summarizing message
 */

public class PatientDriverApp {
    public static void main(String[] args) {
        Patient newpatient = new Patient();
        Scanner keyboard = new Scanner(System.in);

        // Create 3 instances of procedure
        Procedure proc1 = new Procedure();
        Procedure proc2 = new Procedure();
        Procedure proc3 = new Procedure();

        // Collect patient information fill in information
        System.out.println("Enter patients first name: ");
        newpatient.setFirstName(keyboard.nextLine());

        System.out.println("Enter patients middle name: ");
        newpatient.setMiddleName(keyboard.nextLine());

        System.out.println("Enter patients last name: ");
        newpatient.setLastName(keyboard.nextLine());

        System.out.println("Enter patients address: ");
        newpatient.setAddress(keyboard.nextLine());

        System.out.println("Enter city: ");
        newpatient.setCity(keyboard.nextLine());

        System.out.println("Enter state: ");
        newpatient.setState(keyboard.nextLine());

        System.out.println("Enter ZIP code: ");
        newpatient.setZIP(keyboard.nextLine());

        System.out.println("Enter phone number: ");
        newpatient.setPhoneNum(keyboard.nextLine());

        System.out.println("Enter emergency contact name: ");
        newpatient.setEmergencyName(keyboard.nextLine());

        System.out.println("Enter emergency contact phone: ");
        newpatient.setEmergencyNumber(keyboard.nextLine());

        // Procudure 1
        System.out.println("Enter procedure 1 details:");

        System.out.println("Name: ");
        proc1.setProcName(keyboard.nextLine());

        System.out.println("Date: ");
        proc1.setProcDate(keyboard.nextLine());

        System.out.println("Practitioner: ");
        proc1.setPracName(keyboard.nextLine());

        System.out.println("Charge: ");
        proc1.setProcCharge(keyboard.nextDouble());
        keyboard.nextLine();

        // Procudure 2
        System.out.println("Enter procedure 2 details:");

        System.out.println("Name: ");
        proc2.setProcName(keyboard.nextLine());

        System.out.println("Date: ");
        proc2.setProcDate(keyboard.nextLine());

        System.out.println("Practitioner: ");
        proc2.setPracName(keyboard.nextLine());

        System.out.println("Charge: ");
        proc2.setProcCharge(keyboard.nextDouble());
        keyboard.nextLine();

        // Procudure 3
        System.out.println("Enter procedure 3 details:");

        System.out.println("Name: ");
        proc3.setProcName(keyboard.nextLine());

        System.out.println("Date: ");
        proc3.setProcDate(keyboard.nextLine());

        System.out.println("Practitioner: ");
        proc3.setPracName(keyboard.nextLine());

        System.out.println("Charge: ");
        proc3.setProcCharge(keyboard.nextDouble());

        // Print summarys
        System.out.println(newpatient);
        System.out.println(proc1);
        System.out.println(proc2);
        System.out.println(proc3);

        // display total charge
        double totalCharges = proc1.getProcCharge() + proc2.getProcCharge() + proc3.getProcCharge();
        System.out.printf("Total Charges: $%.2f\n", totalCharges);

        // Student name
        System.out.println("\nThis program was developed by Madison Harris \nMC ID: M21186120 \nDue Date: June 30th,2025");

    }

}
