package za.ac.cput.Repository;

/* IMedicationRepository.java
 Repository for Medication
 Author: Onele Tomson (219483280)
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Medication;

@Repository
public interface IMedicationRepository extends JpaRepository<Medication, String>
{

}