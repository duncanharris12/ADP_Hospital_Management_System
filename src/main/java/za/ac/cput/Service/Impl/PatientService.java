package za.ac.cput.Service.Impl;

/*
PatientService
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 13 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Repository.IPatientRepository;
import za.ac.cput.Service.Interfaces.IPatientService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {

    private  final IPatientRepository repository;


    @Autowired
    public PatientService(IPatientRepository iPatientRepository){
        this.repository = iPatientRepository;
    }


    //create or save
    @Override
    public Patient save(Patient patient){
        return this.repository.save(patient);
    }



    //read
    @Override
    public Patient read(String patientID){
        return this.repository.findById(patientID).orElse(null);
    }


    /*
    @Override
    public Patient getPatientByName(String patientName){
        return repository.findByName(patientName);
    }*/

    //delete
    @Override
    public boolean delete (String patientID){

        if(this.repository.existsById(patientID)){
            this.repository.deleteById(patientID);

            return true;
        }
        return false;
    }

    //findAll


    @Override
    public Set<Patient> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


}
