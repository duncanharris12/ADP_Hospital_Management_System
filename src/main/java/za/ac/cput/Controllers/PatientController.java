package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Service.Impl.PatientService;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;
/*
PatientController
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 21 August 2022
 */
@RestController
@RequestMapping("/hospital-management/patient/")
@Slf4j
public class PatientController {

    private final PatientService patientService;

    @Autowired public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("save")
    public ResponseEntity<Patient> save(@Valid @RequestBody Patient savePatient) {
        log.info("Save request: {}", savePatient);
        try {
            Patient patient = this.patientService.save(savePatient);
            return ResponseEntity.ok(patient);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }

    @GetMapping("readPatient/{patientID}")
    public ResponseEntity<Patient> read (@Valid @PathVariable String patientID){

        log.info("Read request: {}", patientID);
        try {
            Patient read = this.patientService.read(patientID);
            return ResponseEntity.ok(read);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deletePatient/{id}")
    public ResponseEntity<Patient> delete (@PathVariable String patientID){
        log.info("Delete request:", patientID);
        this.patientService.delete(patientID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<Set<Patient>> getAll() {
        Set<Patient> patientSet = this.patientService.getAll();
        return ResponseEntity.ok(patientSet);
    }


}

