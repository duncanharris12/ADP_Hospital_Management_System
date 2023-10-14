package za.ac.cput.Service.Impl;
//This is LaboratoryServiceTest.java
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.*;
import za.ac.cput.Factory.*;
import za.ac.cput.Repository.ILaboratoryRepository;
import za.ac.cput.Service.Interfaces.ILaboratoryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LaboratoryServiceTest {


    Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
    Doctor doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department, "Midwife Nurse");
    Patient pat = PatientFactory.createPatient("Nolubabalo Ndongeni", "60 Hug Street", 67367872, "Female", 23, "Hey");
    TestPatient testPatient = TestPatientFactory.createTestPatient("Urine Test", pat);


    private final Laboratory laboratory1 = FactoryLaboratory.createLaboratory("D56", pat, doctor, testPatient, "Medicine laboratory", "Tuesday", 500);
    private final Laboratory laboratory2 = FactoryLaboratory.createLaboratory("D56", pat, doctor, testPatient, "Testing laboratory", "Tuesday", 400);
    private final Laboratory laboratory3 = FactoryLaboratory.createLaboratory("D56", pat, doctor, testPatient, "Skeleton laboratory", "Tuesday", 550);
    private final Laboratory laboratory4 = FactoryLaboratory.createLaboratory("D56", pat, doctor, testPatient, "DNA Test laboratory", "Tuesday", 750);
    private final Laboratory laboratory5 = FactoryLaboratory.createLaboratory("D56", pat, doctor, testPatient, "Medicine laboratory", "Tuesday", 950);

    @Autowired
    private LaboratoryService service;

    @Order(1)
    @Test
    void s_save() {
        System.out.println("Created:    ");
        Laboratory createdLaboratory = service.saveLaboratory(laboratory1);
        assertNotNull(createdLaboratory);
        System.out.println(createdLaboratory);

        Laboratory createdLaboratory2 = service.saveLaboratory(laboratory2);
        assertNotNull(createdLaboratory2);
        System.out.println(createdLaboratory2);

        Laboratory createdLaboratory3 = service.saveLaboratory(laboratory3);
        assertNotNull(createdLaboratory3);
        System.out.println(createdLaboratory3);

        Laboratory createdLaboratory4 = service.saveLaboratory(laboratory4);
        assertNotNull(createdLaboratory4);
        System.out.println(createdLaboratory4);

        Laboratory createdLaboratory5 = service.saveLaboratory(laboratory5);
        assertNotNull(createdLaboratory5);
        System.out.println(createdLaboratory5);


    }

    @Order(3)
    @Test
    void r_read() {
        Laboratory read = service.readLaboratory(laboratory1.getLabID());
        assertEquals(read.getLabID(), laboratory1.getLabID());
        System.out.println("Read:   " + read);
    }

    @Order(4)
    @Test
    void u_update() {

    }

    @Order(5)
    @Test
    void d_delete() {
        boolean success = service.deleteLaboratory(laboratory1.getLabID());
        assertTrue(success);
        System.out.println("Deleted:    " + success);
    }

    @Order(2)
    @Test
    void getAll() {
        System.out.println("Get All: ");
        System.out.println(service.getAllLaboratory());
    }


}
