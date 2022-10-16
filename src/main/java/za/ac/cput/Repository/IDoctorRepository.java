/* IDoctorRepository.java
   Interface for the Doctor Repository
   Author: Chante Lee Davids [220246688]
   Date  : 6 August 2022
*/

package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Doctor;

import java.util.Set;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, String>
{

}
