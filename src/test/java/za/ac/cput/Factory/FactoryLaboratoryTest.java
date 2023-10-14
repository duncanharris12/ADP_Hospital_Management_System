package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 *This is an updated version
 *
 */

class FactoryLaboratoryTest {

    @Test
    public void test() {


        Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        Doctor doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department,"Midwife Nurse");
        Patient pat = PatientFactory.createPatient("Nolubabalo Ndongeni","60 Hug Street", 67367872,"Female",23, "Hey" );
        TestPatient testPatient = TestPatientFactory.createTestPatient("Urine Test", pat);

        Laboratory laboratory = FactoryLaboratory.createLaboratory("D125",pat,doctor,testPatient,"Emergency lab","Tuesday",250);


        System.out.println(laboratory.toString());
        assertNotNull(laboratory);

    }

}

