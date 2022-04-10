/* IBillRepository.java
   Interface for the billRepository
   Author: Davin Shaun Carstens
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import za.ac.cput.Entity.Bill;

import java.util.Set;

public interface IBillRepository extends IRepository<Bill,String>
{
    Bill create(Bill bill);
    Bill read(String billNo);
    public Set<Bill> getAll();
}
