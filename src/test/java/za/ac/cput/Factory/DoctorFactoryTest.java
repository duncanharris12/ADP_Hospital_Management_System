/*  DoctorFactoryTest.java
    Test for the DoctorFactory
    Author: Chante Lee Davids [220246688]
    Date  : 6 August 2022
*/

package za.ac.cput.Factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;

import static org.junit.jupiter.api.Assertions.*;

class DoctorFactoryTest {

    @Test
    void createDoctor() {
        Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        Doctor doctor = DoctorFactory.createDoctor("CLD0609","Chante Davids", "RandomPassword123", department,"Midwife Nurse");
        assertNotNull(doctor);
        System.out.println(doctor);
    }
}