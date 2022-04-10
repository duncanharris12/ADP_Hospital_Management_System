/* BillRespository.java
   Repository For Bill
   Author: Davin Shaun Carstens
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import za.ac.cput.Entity.Bill;

import java.util.HashSet;
import java.util.Set;

public class BillRepository implements IBillRepository
{
    private static BillRepository repository = null;
    private Set<Bill> billDB = null;

    private BillRepository()
    {
        billDB = new HashSet<Bill>();
    }

    public static BillRepository getRepository()
    {
        if(repository == null)
        {
            repository = new BillRepository();
        }
        return repository;
    }

    public Bill create(Bill  bill)
    {
        boolean success = billDB.add(bill);
        if(!success)
            return null;
        return bill;
    }

    public Bill read(String billNo)
    {
        Bill bill = billDB.stream()
                .filter(e ->e.getBillNo().equals(billNo))
                .findAny()
                .orElse(null);
        return bill;
    }

    public Bill update(Bill bill)
    {
        Bill oldBill = read(bill.getBillNo());
        if(oldBill != null)
        {
            billDB.remove(oldBill);
            billDB.add(bill);
            return bill;
        }
        return null;
    }

    public boolean delete(String billNo)
    {
        Bill deleteBill = read(billNo);
        if(deleteBill == null)
            return false;
        billDB.remove(deleteBill);
        return true;
    }

    public Set<Bill> getAll()
    {
        return billDB;
    }
}
