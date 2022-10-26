package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReceptionistTypeControllerTest {

    @LocalServerPort private int port;
    @Autowired private ReceptionistTypeController controller;
    @Autowired TestRestTemplate restTemplate;
    private Receptionist receptionist;
    private final String baseURL = "http://localhost:8080/hospital-management/receptionist-type/";
    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "password";

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.receptionist = ReceptionistFactory.createReceptionist(
                "Jake", "Davina",  716172619);
        String url = baseURL;
    }

    @Test
    void save() {
        String url = baseURL + "save";
        //System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody()));
    }

    @Test
    void read() {
        String url = baseURL + "read" +this.receptionist.getReceptionistID();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
    }
}