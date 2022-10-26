package za.ac.cput.Service.Interfaces;

/**ITestResultsService
 * Interface for TestResultsService
 * Author: Onele Tomson(219483280)
 */

import za.ac.cput.Entity.TestResults;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Set;


public interface ITestResultsService extends IService<TestResults, String> {
    Set<TestResults> getAll();

}
