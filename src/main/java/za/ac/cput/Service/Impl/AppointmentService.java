package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Repository.IAppointmentRepository;
import za.ac.cput.Entity.Appointment;


import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */
@Service
public class AppointmentService{

    private final IAppointmentRepository repository;

    @Autowired
    public AppointmentService (IAppointmentRepository iAppointmentRepository){
        this.repository = iAppointmentRepository;
    }


    public Appointment saveAppointment (Appointment appointment){
        return this.repository.save(appointment);
    }


    public Appointment readAppointment (String appointmentID){
        return this.repository.getById(appointmentID);
    }


    public boolean deleteAppointment (String appointmentID){

        if(this.repository.existsById(appointmentID)){
            this.repository.deleteById(appointmentID);

            return true;
        }
        return false;
    }


    public Set<Appointment> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
