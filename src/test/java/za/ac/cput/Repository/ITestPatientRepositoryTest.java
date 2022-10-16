package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ITestPatientRepositoryTest {
    //private Patient patient;
    private final Patient patient1 = PatientFactory.createPatient( "PHM245","Bulie Ndongeni", "37 GoodWill Street", +687362837,"Female",21,"password@009");;
    private final TestPatient testPatient = TestPatientFactory.createTestPatient("THM111","Blood test",patient1);
    @Autowired private ITestPatientRepository repository;



    @Order(1)
    @Test
    void save(){
        TestPatient save = this.repository.save(this.testPatient);
        assertNotNull(this.testPatient);
    }


    @Order(2)
    @Test
    void read(){
        TestPatient read = this.repository.getReferenceById(this.testPatient.getTestID());
    }


    @Order(3)
    @Test
    void findAll(){
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(4, testPatientList.size());
    }


    @Order(4)
    @Test
    void delete(){
        this.repository.delete(this.testPatient);
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(2, testPatientList.size());
    }





}