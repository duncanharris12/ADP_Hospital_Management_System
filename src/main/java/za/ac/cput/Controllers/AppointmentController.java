package za.ac.cput.Controllers;

//This is a controller class
//This is a Controller.java
//This controller class is responsible for processing incoming REST API request, preparing a model and
//returning the view
//This is AppointmentController.java


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Appointment;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import za.ac.cput.Service.Impl.AppointmentService;

import javax.validation.Valid;

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


    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping("save")
    public ResponseEntity<Appointment> save(@Valid @RequestBody Appointment saveAppointment) {
        log.info("Save request: {}", saveAppointment);
        try {
          Appointment appointment = this.appointmentService.saveAppointment(saveAppointment);
            return ResponseEntity.ok(appointment);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }

    @GetMapping("readAppointment/{appointmentID}")
    public ResponseEntity<Appointment> read (@Valid @PathVariable String appointmentID){

        log.info("Read request: {}", appointmentID);
        try {
         Appointment appointment = this.appointmentService.readAppointment(appointmentID);
            return ResponseEntity.ok(appointment);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteAppointment/{appointmentID}")
    public ResponseEntity<Appointment> delete (@PathVariable String appointmentID){
        log.info("Delete request:", appointmentID);
        this.appointmentService.deleteAppointment(appointmentID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll")
    public ResponseEntity<Set<Appointment>> getAll() {
        Set<Appointment> appointmentSet = this.appointmentService.getAll();
        return ResponseEntity.ok(appointmentSet);
    }


}
