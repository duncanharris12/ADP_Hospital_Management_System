package za.ac.cput.Factory;
/* ReceptionistFactory.java
   Factory Class: ReceptionistFactory(220021333)
   Author: Davin Shaun Carstens
*/
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.util.Helper;

public class ReceptionistFactory
{
    public static Receptionist createReceptionist(String receptionistName,
                                                  String receptionistPassword,
                                                  long receptionistTelephoneNumber)
    {
        String receptionistID = Helper.generateReceptionisID();
        Receptionist reception = new Receptionist.Builder()
                .setReceptionistID(receptionistID)
                .setReceptionistUserName(receptionistName)
                .setReceptionistPassword(receptionistPassword)
                .setReceptionistTelephoneNumber(receptionistTelephoneNumber)
                .build();
        return reception;
    }
}
