package za.ac.cput.Factory;

import za.ac.cput.Entity.Patient;
import za.ac.cput.util.Helper;

/**
PatientFactory.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 **/
public class PatientFactory {
    public static Patient createPatient(String patientID,String patientName ,String address,long phone_number, String sex,
                                        int age,String patientPassword){
        //String patientID = Helper.generatePatientID();

        Patient patient = new Patient.Builder().setPatientID(patientID).setPatientName(patientName)
                .setAddress(address)
                .setPhone_number(phone_number)
                .setSex(sex)
                .setAge(age)
                .setPatientPassword(patientPassword)
                .build();
        return patient;

    }


}
