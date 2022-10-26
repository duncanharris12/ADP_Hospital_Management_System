/* TestResultsFactory.java
 Factory for TestResults
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

package za.ac.cput.Factory;

import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.util.Helper;


public class TestResultsFactory {

    public static TestResults createTestResults(String testResultsID, Patient patient, TestPatient testPatient, String testDate, String testDescription)
    {
        //testID = Helper.generateTestID();

        TestResults testresults = new TestResults.Builder()
                .setTestResultsID(testResultsID)
                .setPatient(patient)
                .setTestPatient(testPatient)
                .setTestDate(testDate)
                .setTestDescription(testDescription)
                .build();
        return testresults;
    }
}