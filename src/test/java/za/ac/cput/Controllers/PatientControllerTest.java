package za.ac.cput.Controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
/*
PatientControllerTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 22 August 2022
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class PatientControllerTest {
    @LocalServerPort private int portNumber;
    @Autowired private PatientController patientController;
    @Autowired private TestRestTemplate restTemplate;
    private Patient patient;
    private  String urlBase;



    @BeforeEach
    void setUp() {
        assertNotNull(patientController);
        this.patient = PatientFactory.createPatient( "PHM872","Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/patient/";
    }

    @Test
    @Order(1)
    void a_create() {
        String url = urlBase + "save";
        System.out.println(url);

        ResponseEntity<Patient> patientResponseEntity = this.restTemplate.postForEntity(url, this.patient, Patient.class);
        System.out.println(patientResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK, patientResponseEntity.getStatusCode()),
                ()-> assertNotNull(patientResponseEntity.getBody()));
        System.out.println("Patient saved!");

    }

    @Test
    @Order(2)
    void b_read() {
        String url = urlBase + "readPatient/" + patient.getPatientID();
        System.out.println(url);
        ResponseEntity<Patient> patientResponseEntity = this.restTemplate.getForEntity(url, Patient.class);
        System.out.println(patientResponseEntity);
        assertAll(
                ()->assertNotNull(patientResponseEntity),
                ()-> assertEquals(HttpStatus.OK,patientResponseEntity.getStatusCode()),
                ()-> assertNotNull(patientResponseEntity.getBody()));

    }

    @Test
    @Order(3)
    void d_delete() {
        String url = urlBase + "deletePatient/" + patient.getPatientID();
        this.restTemplate.delete(url);
        assertNotNull(patient.getPatientName());
        //assertAll(()->assertSame("1",patient.getPatientID()),
                //()->assertNotNull(patient.getPatientName()));
        System.out.println("Delete successful!");

    }

    @Test
    @Order(4)
    void e_getAll() {
        String url = urlBase + "all";

        System.out.println(url);

        ResponseEntity<Patient[]> responseEntity =this.restTemplate.getForEntity(url, Patient[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertEquals(1, responseEntity.getBody().length),
                ()-> assertNotNull(responseEntity));



    }

}