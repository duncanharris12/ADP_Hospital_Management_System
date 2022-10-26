package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;
import za.ac.cput.Repository.ITestPatientRepository;
import za.ac.cput.Service.Impl.TestPatientService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
TestPatientServiceTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 14 August 2022
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestPatientServiceTest {


    @Autowired
    private TestPatientService service;

    private Patient patient;
    //private final Patient patient = PatientFactory.createPatient( "PHM334","Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");;
    private final TestPatient testPatient = TestPatientFactory.createTestPatient("THM878", "Drug test", patient);

    @Test
    @Order(1)
    void save() {
        TestPatient save = service.save(this.testPatient);
        assertEquals(this.testPatient, save);
    }


    @Test
    @Order(2)
    void read() {
        TestPatient read = service.read(testPatient.getTestID());
        assertNotNull(read);
    }


    @Test
    @Order(4)
    void delete() {
        service.delete(testPatient.getTestID());
        assertNotNull(testPatient);
        System.out.println("Deleted: " + testPatient);
    }

    @Test
    @Order(3)
    void getTestPatients() {
        System.out.println("Get all testPatients: ");
        System.out.println(service.getAll());
    }
}
