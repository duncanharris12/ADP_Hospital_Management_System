package za.ac.cput.Factory;

/* TestResultsFactoryTest.java
 Entity for the TestResultsFactoryTest
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Factory.TestResultsFactory;


public class TestResultsFactoryTest {

    @Test
    void createTestResults()
    {
        Patient patient = PatientFactory.createPatient("PHM346" ,"Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
        TestPatient testPatient = TestPatientFactory.createTestPatient("122001","test",patient);
        TestResults testResults = TestResultsFactory.createTestResults("5874",patient,testPatient , "08 May 2022", "Blood Test");
        assertNotNull(testResults);
        System.out.println(testResults);
    }
}