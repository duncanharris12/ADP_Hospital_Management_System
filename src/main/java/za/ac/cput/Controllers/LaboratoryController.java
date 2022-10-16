package za.ac.cput.Controllers;
//This is a controller class
//This is a Controller.java
//This controller class is responsible for processing incoming REST API request, preparing a model and
//returning the view to be rendered as a response.

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Service.Impl.LaboratoryService;

import javax.validation.Valid;

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
    LaboratoryController(LaboratoryService laboratoryService)
    {
        this.laboratoryService = laboratoryService;
    }
    @PostMapping("save/laboratory")
    public ResponseEntity<Laboratory> save(@Valid @RequestBody Laboratory laboratory)
    {
        log.info("Save Request: {}", laboratory);
        Laboratory save = this.laboratoryService.saveLaboratory(laboratory);
        return ResponseEntity.ok(save);
    }

    @GetMapping("getAdmin/{id}")
    public ResponseEntity<Laboratory> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            Laboratory read = this.laboratoryService.readLaboratory(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteAdmin/{id}")
    public ResponseEntity<Laboratory> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.laboratoryService.deleteLaboratory(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("getAll/admin")
//    public ResponseEntity<Set<Administration>> getAll()
//    {
//        Set<Administration> administrationSet = this.administrationService.getAll();
//        return ResponseEntity.ok(administrationSet);
//    }
}