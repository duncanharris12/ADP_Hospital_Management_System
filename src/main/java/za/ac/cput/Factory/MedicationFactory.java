/* MedicationFactory.java
Factory for Medication
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

package za.ac.cput.Factory;

import za.ac.cput.Entity.Medication;
import za.ac.cput.util.Helper;

public class MedicationFactory {

    public static Medication createMedication(String medicationID, String medicationName, float medicationPrice, int medicationQuantity)
    {
        //medicationID = Helper.generateMedicationID();
        Medication medication = new Medication.Builder()
                .setMedicationID(medicationID)
                .setMedicationName(medicationName)
                .setMedicationPrice(medicationPrice)
                .setMedicationQuantity(medicationQuantity)
                .build();
        return medication;
    }





}