/*
DepartmentService
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Department;
import za.ac.cput.Repository.IDepartmentRepository;
import za.ac.cput.Service.Interfaces.IDepartmentService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService {

    private final IDepartmentRepository repository;

    @Autowired
    public DepartmentService(IDepartmentRepository repository){
        this.repository = repository;
    }

    @Override
    public Department save(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Department read(String departmentId) {
        return this.repository.findById(departmentId).orElse(null);
    }

    @Override
    public boolean delete(String departmentId) {
        if(this.repository.existsById(departmentId)){
            this.repository.deleteById(departmentId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Department> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
