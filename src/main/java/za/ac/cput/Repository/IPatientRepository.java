package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Patient;

import java.util.List;
import java.util.Set;
/**
 IPatientRepository.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 Date: 07 August 2022
 **/

@Repository
public interface IPatientRepository extends JpaRepository<Patient, String> {
}
