package za.ac.cput.Controllers;

//Onele Tomson (219483280)

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Medication;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Service.Impl.MedicationServiceImpl;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/medication/")
@Slf4j
public class MedicationController {

    private final MedicationServiceImpl medicationServiceImpl;

    @Autowired
    public MedicationController(MedicationServiceImpl medicationServiceImpl)
    {
        this.medicationServiceImpl = medicationServiceImpl;
    }

    @PostMapping("save")
    public ResponseEntity<Medication> save(@Valid @RequestBody Medication saveMedication) {
        log.info("Save request: {}", saveMedication);
        try {
            Medication medication = this.medicationServiceImpl.save(saveMedication);
            return ResponseEntity.ok(medication);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }

    @GetMapping("readMedication/{medicationID}")
    public ResponseEntity<Medication> read (@Valid @PathVariable String medicationID){

        log.info("Read request: {}", medicationID);
        try {
            Medication read = this.medicationServiceImpl.read(medicationID);
            return ResponseEntity.ok(read);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteMedication/{id}")
    public ResponseEntity<Medication> delete (@PathVariable String medicationID){
        log.info("Delete request:", medicationID);
        this.medicationServiceImpl.delete(medicationID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<Set<Medication>> getAll() {
        Set<Medication> medicationSet = this.medicationServiceImpl.getAll();
        return ResponseEntity.ok(medicationSet);
    }
}
 /*   @GetMapping("getAll/medication")
    public ResponseEntity<Set<Medication>> getAll()
    {
        Set<Medication> medicationSet = this.medicationServiceImpl.getAll();
        return ResponseEntity.ok(medicationSet);
    }

  */






