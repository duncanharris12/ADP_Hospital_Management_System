/*
IDoctorService
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.Doctor;
import za.ac.cput.Service.IService;
import java.util.Set;

public interface IDoctorService extends IService<Doctor, String> {
    Set<Doctor> getAll();
}
