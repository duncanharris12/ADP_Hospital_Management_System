/*  DoctorRepositoryTest.java
    Test for IDoctorRepository
    Author: Chante Lee Davids [220246688]
    Date  : 8 August 2022
*/

package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IDoctorRepositoryTest {

    private IDoctorRepository repository;
    private Doctor doctor;

    @BeforeEach
    void setUp(){
        Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        Doctor doctor = DoctorFactory.createDoctor("CLD0609","Chante Davids", "RandomPassword123", department,"Midwife Nurse");
        assertNotNull(doctor);
        System.out.println(doctor);
    }

    @Test
    @Order(1)
    void save(){
        Doctor save = this.repository.save(this.doctor);
        assertEquals(this.doctor,save);
    }

    @Test
    @Order(2)
    void read() {
        Doctor read = this.repository.getById(this.doctor.getDoctorID());
    }

    @Test
    @Order(3)
    void findAll() {
        List<Doctor> doctorsList = this.repository.findAll();
        assertSame(1, doctorsList.size());
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.doctor.getDoctorID());
        List<Doctor> doctorsList = this.repository.findAll();
        assertSame(0, doctorsList.size());
    }

}