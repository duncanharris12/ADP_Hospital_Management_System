package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Patient;

import static org.junit.jupiter.api.Assertions.*;

class PatientFactoryTest {

    @Test
    void createPatient() {
        Patient pat = PatientFactory.createPatient("PHM346" ,"Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
        assertNotNull(pat);
        System.out.println(pat);

    }
}