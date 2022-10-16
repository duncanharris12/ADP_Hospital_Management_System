package za.ac.cput.Controllers;

//This is a controller class
//This is a Controller.java
//This controller class is responsible for processing incoming REST API request, preparing a model and
//returning the view


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Repository.IAppointmentRepository;
import za.ac.cput.Service.Impl.AppointmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
/**
 * @author: Chuma Nxazonke
 * Student number: 219181187
 * Date: 13 September 2022
 */
@RestController
@RequestMapping("/hospital-management/appointment/")
@Slf4j



public class AppointmentController {


    private AppointmentService appointmentService;

    @Autowired
    AppointmentController(AppointmentService appointmentService)
    {
        this.appointmentService = appointmentService;
    }

    @PostMapping("save/appointment")
    public ResponseEntity<Appointment> save(@Valid @RequestBody Appointment appointment)
    {
        log.info("Save Request: {}", appointment);
        Appointment save = this.appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("getAdmin/{id}")
    public ResponseEntity<Appointment> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            Appointment read = this.appointmentService.readAppointment(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteAdmin/{id}")
    public ResponseEntity<Appointment> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("getAll/admin")
//    public ResponseEntity<Set<Appointment>> getAll()
//    {
//        Set<Appointment> administrationSet = this.appointmentService.;
//        return ResponseEntity.ok(administrationSet);
//    }
}
