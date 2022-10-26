//package za.ac.cput.Controllers;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import za.ac.cput.Entity.MedicalRecords;
//import za.ac.cput.Entity.TestResults;
//import za.ac.cput.Factory.MedicalRecordsFactory;
//import za.ac.cput.Factory.TestResultsFactory;
//
//import java.util.Arrays;
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class MedicalRecordsControllerTest {
//
//    @LocalServerPort
//    private int portNumber;
//
//    @Autowired
//    private MedicalRecordsController medicalRecordsController;
//
//    private MedicalRecords medicalRecords;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private TestResults testResults;
//
//    private String urlBase;
//
//    @BeforeEach
//    void setUp()
//    {
//        this.testResults = TestResultsFactory.createTestResults("Duncan"
//                ,"Male"
//                ,"22"
//                ,"220"
//                ,"negative");
//        this.medicalRecords = MedicalRecordsFactory.createMedicalRecords(testResults);
//        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/medicalRecords/";
//        assertNotNull(medicalRecords);
//    }
//
//
//    @Test
//    @Order(1)
//    void save()
//    {
//        String url = urlBase + "save/medicalRecords";
//        System.out.println(url);
//
//        ResponseEntity<MedicalRecords> medicalRecordsResponseEntity = this.restTemplate.postForEntity(url, this.medicalRecords, MedicalRecords.class);
//        System.out.println(medicalRecordsResponseEntity);
//
//        assertAll(()-> assertEquals(HttpStatus.OK, medicalRecordsResponseEntity.getStatusCode()),
//                ()-> assertNotNull(medicalRecordsResponseEntity.getBody()));
//        System.out.println("Medical Records saved!");
//    }
//
//    @Test
//    @Order(2)
//    void read()
//    {
//        String url = urlBase + "getMedicalRecords/"+medicalRecords.getRecordID();
//        System.out.println(url);
//
//        ResponseEntity<MedicalRecords> medicalRecordsResponseEntity = this.restTemplate.getForEntity(url, MedicalRecords.class);
//        System.out.println(medicalRecordsResponseEntity);
//
//        assertAll(()-> assertEquals(HttpStatus.OK,medicalRecordsResponseEntity.getStatusCode()),
//                ()-> assertNotNull(medicalRecordsResponseEntity.getBody()));
//    }
//
//    @Test
//    @Order(4)
//    void delete()
//    {
//        String url = urlBase + "deleteMedicalRecords/"+medicalRecords.getRecordID();
//        System.out.println(url);
//
//        assertAll(()->assertSame("1",medicalRecords.getRecordID()),
//                ()->assertNotNull(medicalRecords.getTestResults()));
//        System.out.println("Delete successful!");
//    }
//
//    @Test
//    @Order(3)
//    void getAll()
//    {
//        String url = urlBase + "getAll/medicalRecords";
//        System.out.println(url);
//
//        ResponseEntity<MedicalRecords[]> responseEntity =this.restTemplate.getForEntity(url, MedicalRecords[].class);
//        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));
//
//        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
//                ()-> assertTrue(responseEntity.getBody().length == 0),
//                ()-> assertNotNull(responseEntity));
//    }
//}