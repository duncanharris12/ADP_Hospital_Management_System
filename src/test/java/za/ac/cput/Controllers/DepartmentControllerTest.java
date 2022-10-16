package za.ac.cput.Controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentControllerTest {

    @LocalServerPort
    private int portNumber;
    @Autowired private DepartmentController departmentController;
    @Autowired private TestRestTemplate restTemplate;
    private Department department;
    private String urlBase;


    @BeforeEach
    void setUp() {
        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        //this.department = DepartmentFactory.createDepartment("EU", "Emergency Unit", 50);
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/department/";
    }

    @Test
    @Order(1)
    void save() {
        String url = urlBase + "save";
        System.out.println(url);

        ResponseEntity<Department> departmentResponseEntity = this.restTemplate
                .postForEntity(url, this.department, Department.class);
        System.out.println(departmentResponseEntity);

        assertAll(
                ()-> assertEquals(HttpStatus.OK, departmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(departmentResponseEntity.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = urlBase + "readDepartment/" + department.getDepartmentID();
        System.out.println(url);

        ResponseEntity<Department> departmentResponseEntity = this.restTemplate.getForEntity(url, Department.class);
        System.out.println(departmentResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,departmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(departmentResponseEntity.getBody()));
    }

    @Test
    @Order(4)
    void delete() {
        String url = urlBase + "deleteDepartment/" + this.department.getDepartmentID();
        this.restTemplate.delete(url);

        assertNotNull(department.getDepartmentName());
        System.out.println("Delete successful!");
    }

    @Test
    @Order(3)
    void getAll() {
        String url = urlBase + "getAll/department";
        System.out.println(url);

        ResponseEntity<Department[]> responseEntity = this.restTemplate.getForEntity(url, Department[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertEquals(1, responseEntity.getBody().length),
                ()-> assertNotNull(responseEntity));

    }
}