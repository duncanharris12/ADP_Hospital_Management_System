/*
DoctorServiceTest
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;
import za.ac.cput.Repository.IDoctorRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoctorServiceTest {

    private Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
    private final Doctor doctor = DoctorFactory.createDoctor("CLD0609","Chante Davids", "RandomPassword123", department,"Midwife Nurse");

    @Autowired private DoctorService service;
    @Autowired private DepartmentService depservice;

    @Test
    @Order(1)
    void save() {
        System.out.println("Created: ");
        department = depservice.save(department);
        Doctor save = service.save(doctor);
        assertNotNull(doctor);
        System.out.println(save);
        System.out.println(doctor.getDoctorID());
    }

    @Test
    @Order(2)
    void read() {
        Doctor read = service.read(doctor.getDoctorID());
        assertEquals(read.getDoctorID(), doctor.getDoctorID());
        System.out.println("Read: " + read);

    }

    @Test
    @Order(3)
    void getAll() {
        System.out.println("Get All: ");
        System.out.println(service.getAll());
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = service.delete(doctor.getDoctorID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }
}