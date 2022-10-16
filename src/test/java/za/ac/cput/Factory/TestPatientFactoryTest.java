package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;

import static org.junit.jupiter.api.Assertions.*;

class TestPatientFactoryTest {

    @Test
    void createTestPatient() {

        Patient patient = PatientFactory.createPatient("PHM563" ,"Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
        TestPatient testPatient = TestPatientFactory.createTestPatient("THM341","Urine Test", patient);
        assertNotNull(testPatient);
        System.out.println(testPatient);


    }
}