package za.ac.cput.Factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Entity.Doctor;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//In this class I will test an entity called appointment, I built using a factory method.
//I will test it using the data

/**
 * @author Chuma Edward Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 *
 */


class FactoryAppointmentTest {

    @Test
    public void test() {

        Department department = DepartmentFactory.createDepartment(
                "NU",
                "Nursing Unit",
                50);
        Doctor doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department, "Midwife Nurse");
         Appointment appointment = FactoryAppointment.createAppointment("B125", doctor,"Sickness", "I have a flue","Monday", "October");

        assertNotNull(appointment);
        System.out.println(appointment.toString());

    }

}