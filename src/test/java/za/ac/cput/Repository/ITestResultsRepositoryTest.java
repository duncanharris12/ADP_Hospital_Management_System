package za.ac.cput.Repository;

/* ITestResultsRepositoryTest.java
 Test for ITestResultsRepository
 Author: Onele Tomson (219483280)
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.*;

import za.ac.cput.Factory.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ITestResultsRepositoryTest {

    private  final Patient patient = PatientFactory.createPatient("PHM346" ,"Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
    private final TestPatient testPatient = TestPatientFactory.createTestPatient("122001","test",patient);
    private  final TestResults testResults = TestResultsFactory.createTestResults("855",patient,testPatient,"12 December 2022","HIV test results");


    @Autowired private ITestResultsRepository repository;



    @Order(1)
    @Test
    void save(){
        TestResults save = this.repository.save(this.testResults);
        assertEquals(this.testResults,save);
    }

    @Order(2)
    @Test
    void read() {
        TestResults read = this.repository.getById(this.testResults.getTestResultsID());
    }



    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.testResults.getTestResultsID());
        List<TestResults> testResultsList = this.repository.findAll();
        assertSame(0, testResultsList.size());
    }

}
