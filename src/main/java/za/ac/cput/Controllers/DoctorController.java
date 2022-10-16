package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Service.Impl.DoctorService;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/doctor/")
@Slf4j
public class DoctorController {

    private final DoctorService service;

    @Autowired
    public DoctorController(DoctorService service){
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Doctor> save(@RequestBody @Valid Doctor doctor)
    {
        log.info("save request: {}", doctor);
        Doctor saved = this.service.save(doctor);
        return  ResponseEntity.ok(saved);
    }

    @GetMapping("readDoctor/{doctorID}")
    public ResponseEntity<Doctor> read(@PathVariable String doctorId){
        log.info("read request: {}", doctorId);
        Doctor read = this.service.read(doctorId);
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("deleteDoctor/{doctorID}")
    public boolean delete(@PathVariable String doctorID){
        log.info("delete request: {}", doctorID);
        return service.delete(doctorID);
    }

    @GetMapping("getAll/doctor")
    public ResponseEntity<Set<Doctor>> getAll(){
        Set<Doctor> doctorSet = this.service.getAll();
        return ResponseEntity.ok(doctorSet);
    }
}
