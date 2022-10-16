package za.ac.cput.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Service.Impl.TestPatientService;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/*
TestPatientController
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 21 August 2022
 */

@RestController
@RequestMapping("/hospital-management/testPatient/")
@Slf4j
public class TestPatientController {
    private TestPatientService testPatientService;

    @Autowired
    public TestPatientController(TestPatientService testPatientService){
        this.testPatientService = testPatientService;
    }

    @PostMapping("save_testPatient")
    public ResponseEntity<TestPatient> save(@Valid @RequestBody TestPatient saveTestPatient) {
        log.info("Save request: {}", saveTestPatient);
        try {
            TestPatient testPatient = this.testPatientService.save(saveTestPatient);
            return ResponseEntity.ok(testPatient);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("readTestPatient/{testID}")
    public ResponseEntity<TestPatient> read(@PathVariable String testID){
        log.info("Read request: {}", testID);
        try{
            TestPatient read = this.testPatientService.read(testID);
            return ResponseEntity.ok(read);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("deleteTestPatient/{testID}")
    public ResponseEntity<Patient> delete(@PathVariable String testID)   {
        log.info("Delete request:", testID);
        this.testPatientService.delete(testID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getTestPatients")
    public ResponseEntity<List<TestPatient>> getAll(){
        List<TestPatient> testPatientsList =  this.testPatientService.getAll();
        return ResponseEntity.ok(testPatientsList);
    }
}
