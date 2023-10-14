package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.*;
import za.ac.cput.Factory.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Chuma Nxazonke
 *  Student Number: 219181187
 *  Date: 17 July 2022
 *
 */

class ILaboratoryRepositoryTest {

    private ILaboratoryRepository repository;
    private Laboratory laboratory;

    @BeforeEach
    void setUp(){

        Patient pat = PatientFactory.createPatient("Nolubabalo Ndongeni","60 Longmarket Street", 67367872,"Female",23, "Hey@Healthy001" );
        TestPatient testPatient = TestPatientFactory.createTestPatient("Urine Test", pat);
        Department department = DepartmentFactory.createDepartment("NU","Nursing Unit", 50);

        Doctor doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department,"Midwife Nurse");

        Laboratory laboratory = FactoryLaboratory.createLaboratory("D154",pat,doctor,testPatient,"Medicine lab", "Monday", 500);

        assertNotNull(laboratory);
        System.out.println(laboratory);
    }

    @Test
    @Order(1)
    void save(){
        Laboratory save = this.repository.save(this.laboratory);
        assertEquals(this.laboratory,save);
    }

    @Test
    @Order(2)
    void read() {
        Laboratory read = this.repository.getById(this.laboratory.getLabID());
    }

    @Test
    @Order(3)
    void findAll() {
        List<Laboratory> laboratoryList = this.repository.findAll();
        assertSame(1, laboratoryList.size());
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.laboratory.getLabID());
        List<Laboratory> laboratoryList = this.repository.findAll();
        assertSame(0, laboratoryList.size());
    }
}