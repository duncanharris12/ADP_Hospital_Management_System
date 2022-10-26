///*
//    Author: Duncan Benjamin Harris
//    Student Number: 220110530
//    14/08/2022
//*/
//package za.ac.cput.Service.Impl;
//
//import org.junit.jupiter.api.*;
//import za.ac.cput.Entity.Administration;
//import za.ac.cput.Entity.MedicalRecords;
//import za.ac.cput.Entity.TestResults;
//import za.ac.cput.Factory.MedicalRecordsFactory;
//import za.ac.cput.Factory.TestResultsFactory;
//import za.ac.cput.Repository.IMedicalRecordsRepository;
//import za.ac.cput.Service.Interfaces.IMedicalRecordsService;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class MedicalRecordsServiceTest {
//
//    private IMedicalRecordsRepository repository;
//
//    private IMedicalRecordsService service;
//
//    private MedicalRecords medicalRecords;
//
//    private TestResults testResults;
//    @BeforeEach
//    void setUp()
//    {
//        this.testResults = TestResultsFactory.createTestResults("Duncan"
//                ,"Male"
//                ,"22"
//                ,"220"
//                ,"negative");
//        this.medicalRecords = MedicalRecordsFactory.createMedicalRecords(testResults);
//        assertNotNull(medicalRecords);
//    }
//
//    @Test
//    @Order(1)
//    void save()
//    {
//        MedicalRecords save = this.repository.save(this.medicalRecords);
//        assertEquals(this.medicalRecords, save);
//    }
//
//    @Test
//    @Order(2)
//    void read()
//    {
//        MedicalRecords read = this.repository.getById(this.medicalRecords.getRecordID());
//        assertEquals(this.medicalRecords, read);
//    }
//
//    @Test
//    @Order(4)
//    void delete()
//    {
//        this.repository.deleteById(this.medicalRecords.getRecordID());
//        Set<MedicalRecords> medicalRecordsSet = this.repository.findAll().stream().collect(Collectors.toSet());
//        assertSame(0, medicalRecordsSet.size());
//    }
//
//    @Test
//    @Order(3)
//    void getAll()
//    {
//        Set<MedicalRecords> medicalRecordsSet = this.repository.findAll().stream().collect(Collectors.toSet());
//        assertSame(1, medicalRecordsSet.size());
//    }
//}