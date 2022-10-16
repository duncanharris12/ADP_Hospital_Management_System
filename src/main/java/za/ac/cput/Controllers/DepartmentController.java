package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Department;
import za.ac.cput.Service.Impl.DepartmentService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/department/")
@Slf4j
public class DepartmentController {

    private final DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service){
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Department> save(@RequestBody @Valid Department department)
    {
        log.info("save request: {}", department);
        Department saved = this.service.save(department);
        return  ResponseEntity.ok(saved);
    }

    @GetMapping("readDepartment/{departmentID}")
    public ResponseEntity<Department> read(@PathVariable String departmentID){

        log.info("read request: {}", departmentID);
        Department read = this.service.read(departmentID);
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("deleteDepartment/{departmentID}")
    public boolean delete(@PathVariable String departmentID){
        log.info("delete request: {}", departmentID);
        return service.delete(departmentID);
    }

    @GetMapping("getAll/department")
    public ResponseEntity<Set<Department>> getAll(){
        Set<Department> departmentSet = this.service.getAll();
        return ResponseEntity.ok(departmentSet);
    }

}
