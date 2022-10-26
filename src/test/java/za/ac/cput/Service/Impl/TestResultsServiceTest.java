package za.ac.cput.Service.Impl;


import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;
import za.ac.cput.Factory.TestResultsFactory;
import za.ac.cput.Repository.ITestResultsRepository;
import za.ac.cput.Service.Interfaces.ITestResultsService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestResultsServiceTest {

    private ITestResultsRepository repository;

    private ITestResultsService service;

    private TestResults testResults;
    private Patient patient;
    private TestPatient testPatient;



    @BeforeEach
    void setUp()
    {
        this.service = new TestResultsServiceImpl(repository);
        this.patient = PatientFactory.createPatient("PHM346" ,"Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
        this.testPatient = TestPatientFactory.createTestPatient("122001","test",patient);
        this.testResults = TestResultsFactory.createTestResults("855",patient,testPatient,"12 December 2022","HIV test results");

        assertNotNull(testResults);
    }

    @Test
    @Order(1)
    void save()
    {
        TestResults save = this.repository.save(this.testResults);
        assertEquals(this.testResults, save);
    }

    @Test
    @Order(2)
    void read()
    {
        TestResults read = this.repository.getById(this.testResults.getTestResultsID());
        assertEquals(this.testResults, read);
    }

    @Test
    @Order(4)
    void delete()
    {
        this.repository.deleteById(this.testResults.getTestResultsID());
        List<TestResults> testResultsList = this.repository.findAll();
        assertSame(0, testResultsList.size());
    }

    @Test
    @Order(3)
    void getAll()
    {
        List<TestResults> testResultsList = this.repository.findAll();
        assertSame(1, testResultsList.size());
    }
}

