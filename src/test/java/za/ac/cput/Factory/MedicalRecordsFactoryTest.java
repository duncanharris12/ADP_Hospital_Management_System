///* MedicalRecordsFactoryTest.java
//   Factory Test for the MedicalsRecords(220110530)
//   Author: Duncan Benjamin Harris
//   Date: 08 April 2022
//*/
//package za.ac.cput.Factory;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import za.ac.cput.Entity.MedicalRecords;
//import za.ac.cput.Entity.Patient;
//import za.ac.cput.Entity.TestResults;
//
//
//public class MedicalRecordsFactoryTest {
//
//    @Test
//    void createMedicalRecords()
//    {
//
//        TestResults testResults = TestResultsFactory.createTestResults("Duncan"
//                ,"Male"
//                ,"22"
//                ,"220"
//                ,"negative");
//        MedicalRecords medicalRecords = MedicalRecordsFactory.createMedicalRecords(testResults);
//        assertNotNull(medicalRecords);
//        System.out.println(medicalRecords);
//    }
//}
//
