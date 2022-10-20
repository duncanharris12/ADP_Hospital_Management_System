package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Factory.MedicalRecordsFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IMedicalRecordsRepositoryTest {

    private IMedicalRecordsRepository repository;

    private MedicalRecords medicalRecords;

    @BeforeEach
    void setUp() {
        this.medicalRecords = MedicalRecordsFactory.createMedicalRecords("22"
              ,"Duncan"
              ,28
              ,"Male"
               ,"False");
        assertNotNull(medicalRecords);
    }

    @Test
    @Order(1)
    void save()
    {
        MedicalRecords save = this.repository.save(this.medicalRecords);
        assertEquals(this.medicalRecords, save);
    }

    @Test
    @Order(2)
    void read()
    {
        MedicalRecords read= this.repository.getById(this.medicalRecords.getRecordID());
    }

    @Test
    @Order(4)
    void delete()
    {
        this.repository.deleteById(this.medicalRecords.getRecordID());
        List<MedicalRecords> medicalRecordsList = this.repository.findAll();
        assertSame(0, medicalRecordsList.size());
    }

    @Test
    @Order(3)
    void findAll()
    {
        List<MedicalRecords> medicalRecordsList = this.repository.findAll();
        assertSame(1, medicalRecordsList.size());
    }
}