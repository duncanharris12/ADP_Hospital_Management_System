package za.ac.cput.Service.Impl;

/*
TestPatientService
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 13 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Repository.ITestPatientRepository;
import za.ac.cput.Service.Interfaces.ITestPatientService;

import java.util.List;

@Service
public class TestPatientService implements ITestPatientService {
    private final ITestPatientRepository repository;

    @Autowired
    public TestPatientService(ITestPatientRepository iTestPatientRepository){
        this.repository = iTestPatientRepository;
    }



    //save
    @Override
    public TestPatient save(TestPatient testPatient){
        return repository.save(testPatient);
    }


    //read
    @Override
    public TestPatient read(String testID){
        return repository.findById(testID).orElse(null);
    }

    //delete
    @Override
    public boolean delete (String testID){

        if(this.repository.existsById(testID)){
            this.repository.deleteById(testID);

            return true;
        }
        return false;
    }

//    //findAll
//    public List<TestPatient> getTestPatients(){
//        return repository.getAll();
//    }

    @Override
    public List<TestPatient> getAll() {
        return repository.findAll();
    }


}
