package za.ac.cput.util;

import java.util.Random;
import java.util.UUID;

/**
 * This is a helper class
 */
public class Helper 
{
    public static boolean isNullorEmpty(String x) {
        return ( x == null || x.equals("") || x.equalsIgnoreCase("null"));
    }

    //Generating primary key for Appointment class
    public static String generateAppointmentID()
    {
        return UUID.randomUUID().toString();
    }

    //Generating primary key for labroratory class
    public static String generateLaboratoryID()
    {
        return UUID.randomUUID().toString();
    }


    //Generating primary key for patient class
    public static String generatePatientID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for receptionist class
    public static String generateReceptionisID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for bill class
    public static String generateBillID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for test class
    public static String generateTestID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for medication class
    public static String generateMedicationID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for labroratory class
    public static String generateLabroratoryID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for administration class
    public static String generateAdministrationID()
    {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
    
    //Generating primary key for department class
    public static String generateDepartmentID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for doctor class
    public static String generateDoctorID()
    {
        return UUID.randomUUID().toString();
    }
    
    //Generating primary key for record class
    public static String generateRecordID()
    {
        return UUID.randomUUID().toString();
    }
}

