package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Repository.ITestResultsRepository;
import za.ac.cput.Service.Interfaces.ITestResultsService;

import java.util.List;

@Service
public class TestResultsServiceImpl implements ITestResultsService {
    private final ITestResultsRepository repository;

    @Autowired
    public TestResultsServiceImpl(ITestResultsRepository testResultsRepository) {
        this.repository = testResultsRepository;
    }

    @Override
    public TestResults save(TestResults testResults) {
        return this.repository.save(testResults);
    }

    @Override
    public TestResults read(String testID) {
        return this.repository.getById(testID);

    }


    @Override
    public boolean delete(String id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public List<TestResults> getTestResults() {
        return null;

    }
}
