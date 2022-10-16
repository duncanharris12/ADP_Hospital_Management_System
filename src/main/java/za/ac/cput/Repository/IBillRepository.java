package za.ac.cput.Repository;
/* IBillRepository.java
   Repository Class: IBillRepository(220021333)
   Author: Davin Shaun Carstens
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Bill;

import java.util.List;
import java.util.Set;
@Repository
public interface IBillRepository extends JpaRepository<Bill,String>
{

}
