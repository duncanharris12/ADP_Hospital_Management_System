/* MedicalRecordsFactoryTest.java
   Factory Test for the MedicalsRecords
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Entity.MedicalRecords;

public class MedicalRecordsFactoryTest {
   
    @Test
    void createMedicalRecords()
    {
        MedicalRecords medicalRecords = MedicalRecordsFactory.createMedicalRecords
                                        ("7672676272", "James", 27, "Male", "Postive for Aids");
        assertNotNull(medicalRecords);
        System.out.println(medicalRecords);
    }
}
