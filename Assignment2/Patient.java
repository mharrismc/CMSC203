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
 * The Patient class handles patient information
 */
public class Patient {
	
	//fields
   private String firstName;
   private String middleName;
   private String lastName;

   private String streetAddress;
   private String city;
   private String state;
   private String zip;

   private String phoneNum;

   private String emergencyName;
   private String emergencyNum;

   /**
    Constructor
    */
   public Patient() {
      firstName = "";
      middleName = "";
      lastName = "";

      streetAddress = "";
      city = "";
      state = "";
      zip = "";

      phoneNum = "";

      emergencyName = "";
      emergencyNum = "";
   }

   // constructor to initialize patients name
   /**
    * Constructor
    * @param fName The patients first name
    * @param mName The patients middle name
    * @param lName The patients last name
    */
   public Patient(String fName, String mName, String lName) {
      firstName = fName;
      middleName = mName;
      lastName = lName;

      streetAddress = "";
      city = "";
      state = "";
      zip = "";

      phoneNum = "";

      emergencyName = "";
      emergencyNum = "";
   }
   
   /**
    Constructor
    * @param fName Patients first name
    * @param mName Patients middle name
    * @param lName Patients last name
    * @param addr Patients address
    * @param pcity Patients city
    * @param pstate Patients state
    * @param pzip Patients ZIP code
    * @param pnum Patients phone number
    * @param eName Patients emergency contact name
    * @param eNum PAtients emergency phone number
    */
   
   public Patient(String fName, String mName, String lName, String addr, String pcity, String pstate, String pzip,
         String pnum, String eName, String eNum) {
      firstName = fName;
      middleName = mName;
      lastName = lName;
      streetAddress = addr;
      city = pcity;
      state = pstate;
      zip = pzip;
      phoneNum = pnum;
      emergencyName = eName;
      emergencyNum = eNum;
   }

   // Accessors
   
   /**
    @return The patients first name
    */
   public String getFirstName() {
      return firstName;
   }
   
   /**
    * @return the patients middle name
    */
   public String getMiddleName() {
      return middleName;
   }
   
   /**
    * @return The patients last name
    */
   public String getLastName() {
      return lastName;
   }
   
   /**
    * @return the patients street address
    */
   public String getStreet() {
      return streetAddress;
   }
   
   
   /**
    * @return the patients city
    */
   public String getCity() {
      return city;
   }
   
   /**
    * @return the patients state
    */
   public String getState() {
      return state;
   }
   
   /**
    * @return the patients zip code
    */
   public String getZIP() {
      return zip;
   }
   /**
    * @return The patients phone number
    */
   public String getPhoneNumber() {
      return phoneNum;
   }
   
   /**
    * 
    * @return the patients emergency contact name
    */
   public String getEmergencyName() {
      return emergencyName;
   }
   
   /**
    * 
    * @return the patients emergency contact phone number
    */
   public String getEmergencyNumber() {
      return emergencyNum;
   }

   // Mutators
   
   /**
    * 
    * @param fname
    */
   public void setFirstName(String fname) {
      firstName = fname;
   }
   
   /**
    * 
    * @param mname
    */
   public void setMiddleName(String mname) {
      middleName = mname;
   }
    /**
     * 
     * @param lname
     */
   public void setLastName(String lname) {
      lastName = lname;
   }
   
   /**
    * 
    * @param addr
    */
   public void setAddress(String addr) {
      streetAddress = addr;
   }

   /**
    * 
    * @param pcity
    */
   public void setCity(String pcity) {
      city = pcity;
   }

   /**
    * 
    * @param pstate
    */
   public void setState(String pstate) {
      state = pstate;
   }

   /**
    * 
    * @param pzip
    */
   public void setZIP(String pzip) {
      zip = pzip;
   }

   /**
    * 
    * @param pnum
    */
   public void setPhoneNum(String pnum) {
      phoneNum = pnum;
   }

   /**
    * 
    * @param eName
    */
   public void setEmergencyName(String eName) {
      emergencyName = eName;
   }

   /**
    * 
    * @param eNum
    */
   public void setEmergencyNumber(String eNum) {
      emergencyNum = eNum;
   }

   // concatenates patients name
   /**
    * 
    * @return The patients full name
    */
   public String buildFullName() {
      return firstName + " " + middleName + " " + lastName;
   }

   // concatenates address
   /**
    * 
    * @return The patients full address
    */
   public String buildAddress() {
      return streetAddress + " " + city + " " + state + " " + zip;
   }

   // concatenates emergency contact information
   /**
    * 
    * @return The patients emergency contact information
    */
   public String buildEmergencyContact() {
      return emergencyName + " " + emergencyNum;
   }

   // displays patient information
   /**
    * @return all patients information
    */
   public String toString() {
      return "Patient info:\n" +
            "  Name: " + buildFullName() + "\n" +
            "  Address: " + buildAddress() + "\n" +
            "  EmergencyContact: " + buildEmergencyContact() + "\n";
   }
}