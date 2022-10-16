package za.ac.cput.Factory;


import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.util.Helper;


/**
 TestPatientFactory.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 **/

public class TestPatientFactory {
    public static TestPatient createTestPatient(String testID,String testName, Patient patient)
    {
        //String testID = Helper.generateTestID();

        TestPatient testPatient = new TestPatient.Builder().setTestID(testID).setTestName(testName).setPatient(patient).build();
        return testPatient;

    }
}
