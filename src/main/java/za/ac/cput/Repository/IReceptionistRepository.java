/* IReceptionistRepository.java
   Interface for the receptionRepository
   Author: Davin Shaun Carstens
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import za.ac.cput.Entity.Receptionist;

import java.util.Set;

public interface IReceptionistRepository extends IRepository<Receptionist, String>
{
//    Receptionist create(Receptionist receptionist);
//    Receptionist read(String receptionistID);

    public Set<Receptionist> getAll();
}
