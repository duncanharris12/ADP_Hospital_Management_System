package za.ac.cput.Service.Impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Medication;
import za.ac.cput.Repository.IMedicationRepository;
import za.ac.cput.Service.Interfaces.IMedicationService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements IMedicationService {
    private IMedicationRepository repository;

    @Override
    public Medication save(Medication medication) {
        return this.repository.save(medication);

    }

    @Override
    public Medication read(String id) {
        return this.repository.findById(id).orElse(null);

    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Set<Medication> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}