package za.ac.cput.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Service.Impl.TestResultsServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/hospital-management/testResults/")
@Slf4j
public class TestResultsController {

    private TestResultsServiceImpl testResultsServiceImpl;

    @Autowired
    public TestResultsController(TestResultsServiceImpl testResultsServiceImpl)
    {
        this.testResultsServiceImpl = testResultsServiceImpl;
    }

    @PostMapping("save_testResults")
    public ResponseEntity<TestResults> save(@Valid @RequestBody TestResults saveTestResults)
    {
        log.info("Save Request: {}", saveTestResults);
        try {
            TestResults testResults = this.testResultsServiceImpl.save(saveTestResults);
            return ResponseEntity.ok(testResults);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @GetMapping("readTestResults/{testResultsID}")
    public ResponseEntity<TestResults> read(@PathVariable String testResultsID){
        log.info("Read request: {}", testResultsID);
        try{
            TestResults read = this.testResultsServiceImpl.read(testResultsID);
            return ResponseEntity.ok(read);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("deleteTestResults/{testResultsID}")
    public ResponseEntity<Patient> delete(@PathVariable String testResultsID)   {
        log.info("Delete request:", testResultsID);
        this.testResultsServiceImpl.delete(testResultsID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getTestResults")
    public ResponseEntity<Set<TestResults>> getAll(){
        Set<TestResults> testResultsList =  this.testResultsServiceImpl.getAll();
        return ResponseEntity.ok(testResultsList);
    }
}

