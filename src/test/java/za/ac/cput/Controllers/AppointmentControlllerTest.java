package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Factory.DoctorFactory;
import za.ac.cput.Factory.FactoryAppointment;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest

class AppointmentControlllerTest {


    @LocalServerPort
    private int portNumber;
    @Autowired
    private AppointmentController appointmentController;

    private TestRestTemplate restTemplate;
    private Appointment appointment;
    private Doctor doctor;
    private Department department;
    private String urlBase;


    @BeforeEach
    void setUp() {
     this.department= DepartmentFactory.createDepartment(
                "NU",
                "Nursing Unit",
                50);

      this.doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department, "Midwife Nurse");

        this.appointment = FactoryAppointment.createAppointment("B125", doctor,"Sickness", "I have a flue","Monday", "October");
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/appointment/";

        assertNotNull(appointmentController);
    }

    @Test
    void a_save() {
        String url = urlBase + "saveAppointment";
        System.out.println(url);

        ResponseEntity<Appointment> appointmentResponseEntity = this.restTemplate.postForEntity(url, this.appointment, Appointment.class);
        System.out.println(appointmentResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK, appointmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(appointmentResponseEntity.getBody()));
        System.out.println("Appointment saved!");
    }

    @Test
    void b_read() {
        String url = urlBase + "readAppointment/" + appointment.getAppointmentID();
        System.out.println(url);

        ResponseEntity<Appointment> appointmentResponseEntity = this.restTemplate.getForEntity(url, Appointment.class);
        System.out.println(appointmentResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,appointmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(appointmentResponseEntity.getBody()));
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteAppointment/" + appointment.getAppointmentID();
        this.restTemplate.delete(url);

        assertAll(()->assertSame("1",appointment.getAppointmentID()),
                ()->assertNotNull(appointment.getAppointmentDay()));
        System.out.println("Delete successful!");
    }

    @Test
    void e_getAllAppointment() {
        String url = urlBase + "getAppointment";
        System.out.println(url);

        ResponseEntity<Appointment[]> responseEntity =this.restTemplate.getForEntity(url, Appointment[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }




}