package za.ac.cput.Controllers;
//This is a LaboratoryController.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.*;
import za.ac.cput.Factory.*;


import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 15 September 2022
 * This is an updated file
 */

class LaboratoryControllerTest {

    @LocalServerPort
    private int portNumber;
    @Autowired
    private LaboratoryController laboratoryController;

    private Doctor doctor;
    private Department department;
    private Patient pat;
    private TestPatient testPatient;
    private TestRestTemplate restTemplate;
    private Laboratory laboratory;
    private String urlBase;


    @BeforeEach
    void setUp() {

        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        this.doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department, "Midwife Nurse");
        this.pat = PatientFactory.createPatient("Nolubabalo Ndongeni", "60 Hug Street", 67367872, "Female", 23, "Hey");
        this.testPatient = TestPatientFactory.createTestPatient("Urine Test", pat);

        Laboratory laboratory = FactoryLaboratory.createLaboratory("D125", pat, doctor, testPatient, "Emergency lab", "Tuesday", 250);

        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/laboratory/";

        assertNotNull(laboratoryController);
    }

    @Test
    void a_save() {
        String url = urlBase + "saveLaboratory";
        System.out.println(url);

        ResponseEntity<Laboratory> laboratoryResponseEntity = this.restTemplate.postForEntity(url, this.laboratory, Laboratory.class);
        System.out.println(laboratoryResponseEntity);

        assertAll(() -> assertEquals(HttpStatus.OK, laboratoryResponseEntity.getStatusCode()),
                () -> assertNotNull(laboratoryResponseEntity.getBody()));
        System.out.println("Laboratory saved!");
    }

    @Test
    void b_read() {
        String url = urlBase + "readLaboratory/" + laboratory.getLabID();
        System.out.println(url);

        ResponseEntity<Laboratory> laboratoryResponseEntity = this.restTemplate.getForEntity(url, Laboratory.class);
        System.out.println(laboratoryResponseEntity);

        assertAll(() -> assertEquals(HttpStatus.OK, laboratoryResponseEntity.getStatusCode()),
                () -> assertNotNull(laboratoryResponseEntity.getBody()));
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteLaboratory/" + laboratory.getLabID();
        this.restTemplate.delete(url);

        assertAll(() -> assertSame("1", laboratory.getLabID()),
                () -> assertNotNull(laboratory.getLabName()));
        System.out.println("Delete successful!");
    }

    @Test
    void e_getAllLaboratory() {
        String url = urlBase + "getLaboratory";
        System.out.println(url);

        ResponseEntity<Laboratory[]> responseEntity = this.restTemplate.getForEntity(url, Laboratory[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(() -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity));
    }

}