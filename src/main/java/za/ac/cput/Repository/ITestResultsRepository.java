package za.ac.cput.Repository;

/* ITestResultsRepository.java
 Repository for TestResults
 Author: Onele Tomson (219483280)
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.TestResults;

@Repository
public interface ITestResultsRepository extends JpaRepository<TestResults, String > {
}