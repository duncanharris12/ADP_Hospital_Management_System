package za.ac.cput.Repository;
//This is an interface that has a get all method
//This is ILaboratoryRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Laboratory;

import java.util.List;
import java.util.Set;

/**
 * Chuma Nxazonke
 * Student Number: 219181187
 * Date: 07 August 2022
 * This is an updated version
 */
@Repository
public interface ILaboratoryRepository extends JpaRepository<Laboratory, String> {


}
