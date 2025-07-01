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
 * The Procedure class handles procedure information
 */
public class Procedure {
	//fields
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharges;
    
    

    public Procedure() {
        procedureName = "";
        procedureDate = "";
        practitionerName = "";
        procedureCharges = 0.0;
    }

    /**
     * 
     * @param procName Procedure name
     * @param procDate Procedure date
     */
    public Procedure(String procName, String procDate) {
        procedureName = procName;
        procedureDate = procDate;
        practitionerName = "";
        procedureCharges = 0.0;

    }
    
    /**
     * 
     * @param procName Procedure name
     * @param procDate Procedure date
     * @param pracName Practitioner name
     * @param procCharge Procedure charge
     */
    public Procedure(String procName, String procDate, String pracName, double procCharge) {
        procedureName = procName;
        procedureDate = procDate;
        practitionerName = pracName;
        procedureCharges = procCharge;
    }

    //Accessors
    /**
     * 
     * @return procedure name
     */
    public String getProcName() {
        return procedureName;
    }
    
    /**
     * 
     * @return Procedure date
     */
    public String getProcDate() {
        return procedureDate;
    }
    
    /**
     * 
     * @return Practitioner name
     */
    public String getPracName() {
        return practitionerName;
    }
    
    /**
     * 
     * @return procedure charge
     */
    public double getProcCharge() {
        return procedureCharges;
    }

    // Mutators
    /**
     * 
     * @param procName
     */
    public void setProcName(String procName) {
        procedureName = procName;
    }
    /**
     * 
     * @param procDate
     */
    public void setProcDate(String procDate) {
        procedureDate = procDate;
    }
    /**
     * 
     * @param pracName
     */
    public void setPracName(String pracName) {
        practitionerName = pracName;
    }
    /**
     * 
     * @param procCharge
     */
    public void setProcCharge(double procCharge) {
        procedureCharges = procCharge;
    }
    
    /**
     * @return displays all procedure information
     */
    public String toString() {
        return "\t \tProcedure: " + getProcName() + "\n" +
                "\t \tProcedure Date: " + getProcDate() + "\n" +
                "\t \tPractitioner: " + getPracName() + "\n" +
                "\t \tCharge: " + getProcCharge();
    }

}
