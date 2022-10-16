package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
IPatientRepositoryTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 13 August 2022
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IPatientRepositoryTest {
    private final Patient patient = PatientFactory.createPatient( "PHM245","Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
    @Autowired private IPatientRepository repository;



    @Order(1)
    @Test
    void save(){
        Patient save = this.repository.save(this.patient);
        assertEquals(this.patient, save);
    }


    @Order(2)
    @Test
    void read(){
        Patient read = this.repository.getReferenceById(this.patient.getPatientID());
    }

    @Order(4)
    @Test
    void delete(){
        this.repository.delete(this.patient);
        List<Patient> patientList = this.repository.findAll();
        assertSame(10, patientList.size());
    }


    @Order(3)
    @Test
    void findAll(){
        List<Patient> patientList = this.repository.findAll();
        assertSame(10, patientList.size());
    }

}

