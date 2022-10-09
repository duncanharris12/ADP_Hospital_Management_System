package za.ac.cput.Controllers;
//This is a controller class
//This is a Controller.java
//This controller class is responsible for processing incoming REST API request, preparing a model and
//returning the view to be rendered as a response.
//This is LaboratoryController.java

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Service.Impl.LaboratoryService;
import javax.validation.Valid;
import java.util.List;


/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 14 September 2022
 */

@RestController
@RequestMapping("/hospital-management/laboratory/")
@Slf4j
public class LaboratoryController {

    private LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryController(LaboratoryService laboratoryService){
        this.laboratoryService = laboratoryService;
    }

    @PostMapping("save_laboratory")
    public ResponseEntity<Laboratory> save(@Valid @RequestBody Laboratory saveLaboratory) {
        log.info("Save request: {}", saveLaboratory);
        try {
            Laboratory laboratory = this.laboratoryService.saveLaboratory(saveLaboratory);
            return ResponseEntity.ok(laboratory);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("readLaboratory/{labID}")
    public ResponseEntity<Laboratory> read(@PathVariable String labID){
        log.info("Read request: {}", labID);
        try{
            Laboratory laboratory = this.laboratoryService.readLaboratory(labID);
            return ResponseEntity.ok(laboratory);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("deleteLaboratory/{labID}")
    public ResponseEntity<Laboratory> delete(@PathVariable String labID)   {
        log.info("Delete request:", labID);
       this.laboratoryService.deleteLaboratory(labID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAllLaboratory")
    public ResponseEntity<List<Laboratory>> getAllLaboratory(){
        List<Laboratory> laboratoryList = this.laboratoryService.getAllLaboratory();
        return ResponseEntity.ok(laboratoryList);
    }
}