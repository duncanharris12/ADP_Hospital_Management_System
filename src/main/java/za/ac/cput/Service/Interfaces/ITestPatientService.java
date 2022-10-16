package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Service.IService;

import java.util.List;

/*
ITestPatientService
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 13 August 2022
 */
public interface ITestPatientService extends IService<TestPatient, String> {
    //List<TestPatient> getTestPatients();
    List<TestPatient> getAll();


}
