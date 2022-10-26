package za.ac.cput.Controllers;
/* ReceptionistTypeController.java
   Controller Class: ReceptionistTypeController(220021333)
   Author: Davin Shaun Carstens
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Service.Impl.ReceptionistServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/hospital-management/receptionist-type/")
@Slf4j
public class ReceptionistTypeController {
    private ReceptionistServiceImpl receptionistService;

    @Autowired
    public ReceptionistTypeController(ReceptionistServiceImpl receptionistService) {
        this.receptionistService = receptionistService;
    }

    @PostMapping("save")
    public ResponseEntity<Receptionist> save(@Valid @RequestBody Receptionist receptionist){
        log.info("Save Request: {}", receptionist);
        Receptionist save = this.receptionistService.save(receptionist);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Receptionist> read(@PathVariable String id){
        log.info("Read request: {}", id);
        try{
            Receptionist read = this.receptionistService.read(id);
            return ResponseEntity.ok(read);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Receptionist> delete(@PathVariable String id){
        log.info("Delete Request: {}", id);
        this.receptionistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
