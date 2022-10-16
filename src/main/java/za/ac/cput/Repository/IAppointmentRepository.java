package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Appointment;

import java.util.List;

/**
 * Chuma Nxazonke
 * Student Number: 219181187
 * Date: 06 August 2022
 * This is an updated version
 */
@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, String> {


}
