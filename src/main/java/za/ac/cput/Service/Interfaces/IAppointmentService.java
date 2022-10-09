package za.ac.cput.Service.Interfaces;

import za.ac.cput.Service.IService;
import za.ac.cput.Entity.Appointment;

import java.util.Set;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */

public interface IAppointmentService extends IService<Appointment, String> {
    Set<Appointment> getAll();

}
