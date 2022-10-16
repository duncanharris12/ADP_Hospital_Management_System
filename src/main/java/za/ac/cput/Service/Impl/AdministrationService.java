/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Repository.IAdministrationRepository;
import za.ac.cput.Service.Interfaces.IAdministrationService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdministrationService implements IAdministrationService
{
    private final IAdministrationRepository repository;

    @Autowired
    public AdministrationService(IAdministrationRepository administrationRepository)
    {
        this.repository = administrationRepository;
    }

    @Override
    public Administration save(Administration administration)
    {

        return this.repository.save(administration);
    }

    @Override
    public Administration read(String adminID) {
        return this.repository.findById(adminID).orElse(null);
    }

    @Override
    public boolean delete(String adminID) {
        if(this.repository.existsById(adminID))
        {
            this.repository.deleteById(adminID);
            return true;
        }
        return false;
    }

    @Override
    public Set<Administration> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
