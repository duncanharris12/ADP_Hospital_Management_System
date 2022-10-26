package za.ac.cput.Controllers;
//Onele Tomson (219483280)

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;
import za.ac.cput.Factory.TestResultsFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestResultsControllerTest {

    @LocalServerPort
    private int portNumber;
    @Autowired
    private TestResultsController testResultsController;
    @Autowired
    private TestRestTemplate restTemplate;
    private TestResults testResults;
    private Patient patient;
    private TestPatient testPatient;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(testResultsController);
        this.patient = PatientFactory.createPatient("PHM346" ,"Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
        this.testPatient = TestPatientFactory.createTestPatient("122001","test",patient);
        this.testResults = TestResultsFactory.createTestResults("855",patient,testPatient,"12 December 2022","HIV test results");
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/testResults/";

    }

    @Test
    void a_save() {
        String url = urlBase + "saveTestResults";
        System.out.println(url);

        ResponseEntity<TestResults> testResultsResponseEntity = this.restTemplate.postForEntity(url, this.testResults, TestResults.class);
        System.out.println(testResultsResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,testResultsResponseEntity.getStatusCode()),
                ()-> assertNotNull(testResultsResponseEntity.getBody()));
        System.out.println("Test Results saved!");
    }

    @Test
    void b_read() {
        String url = urlBase + "readTestResults/" + testResults.getTestResultsID();
        System.out.println(url);

        ResponseEntity<TestResults> testResultsResponseEntity = this.restTemplate.getForEntity(url, TestResults.class);
        System.out.println(testResultsResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,testResultsResponseEntity.getStatusCode()),
                ()-> assertNotNull(testResultsResponseEntity.getBody()));
    }

  /*  @Test
    void d_delete() {
        String url = urlBase + "deleteTestResults/" + testResults.getTestID();
        this.restTemplate.delete(url);

        assertAll(()->assertSame("1",testResults.getTestID()
        System.out.println("Successfully Deleted")));
    }

   */
    @Test
    void e_getAll() {
        String url = urlBase + "getTestResults";
        System.out.println(url);

        ResponseEntity<TestResults[]> responseEntity =this.restTemplate.getForEntity(url, TestResults[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }
}
