package za.ac.cput.Controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
/*
TestPatientControllerTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 22 August 2022
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestPatientControllerTest {

    @LocalServerPort private int portNumber;
    @Autowired
    private TestPatientController testPatientController;
    @Autowired
    private TestRestTemplate restTemplate;
    private Patient patient;
    private TestPatient testPatient;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(testPatientController);
        this.testPatient = TestPatientFactory.createTestPatient("THM786","Blood DNA", patient);
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/testPatient/";
    }

    @Test
    @Order(1)
    void save() {
        String url = urlBase + "save_testPatient";
        System.out.println(url);
        ResponseEntity<TestPatient> testPatientResponseEntity = this.restTemplate.postForEntity(url, this.testPatient, TestPatient.class);
        System.out.println(testPatientResponseEntity);
        assertAll(()-> assertEquals(HttpStatus.OK, testPatientResponseEntity.getStatusCode()),
                ()-> assertNotNull(testPatientResponseEntity.getBody()));
        System.out.println("Test saved!");
    }

    @Test
    @Order(2)
    void b_read() {
        String url = urlBase + "readTestPatient/" + testPatient.getTestID();
        System.out.println(url);
        ResponseEntity<TestPatient> testPatientResponseEntity = this.restTemplate.getForEntity(url, TestPatient.class);
        System.out.println(testPatientResponseEntity);
        assertAll(()->assertNotNull(testPatientResponseEntity),
                () -> assertEquals(HttpStatus.OK,testPatientResponseEntity.getStatusCode()));
                //()-> assertEquals(HttpStatus.OK,testPatientResponseEntity.getBody()));

    }

    @Test
    @Order(4)
    void d_delete() {
        String url = urlBase + "deleteTestPatient/" + testPatient.getTestID();
        this.restTemplate.delete(url);
        //assertAll(()->assertSame("1",testPatient.getTestID()),
                assertNotNull(testPatient.getTestName());
        System.out.println("Delete successful!");


    }

    @Test
    @Order(3)
    void c_getAll() {
        String url = urlBase + "getTestPatients";

        System.out.println(url);

        ResponseEntity<TestPatient[]> responseEntity =this.restTemplate.getForEntity(url, TestPatient[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));

    }
}


