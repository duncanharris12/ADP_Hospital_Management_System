package za.ac.cput.Factory;

//This is a worker class for laboratory entity under factory package.
//In this class will implement an entity called Laboratory using a factory pattern.
//Laboratory.java

import za.ac.cput.Entity.Doctor;
import za.ac.cput.Entity.Laboratory;


import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.util.Helper;
/**
 *
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 07 April 2022
 * This is an updated version
 */

public class FactoryLaboratory {

    public static Laboratory createLaboratory( String labID, Patient pat, Doctor doctor, TestPatient testPatient, String labName, String labDay, double amount){

        //String labID = Helper.generateLaboratoryID();

        if (Helper.isNullorEmpty(labName) || Helper.isNullorEmpty(labDay))
            return null;


        Laboratory laboratory = new Laboratory.Builder().setLabID(labID)
                .setPatient(pat)
                .setDoctor(doctor)
                .setTestPatient(testPatient)
                .setLabName(labName)
                .setLabDay(labDay)
                .setAmount(amount)
                .build();

        return  laboratory;

    }


}
