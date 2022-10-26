/* TestResults.java
 Entity for the TestResults
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

package za.ac.cput.Entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class TestResults {

    @Id
    @Column(name = "test_results_id")
    private String testResultsID;
    @JoinColumn(name="patient_id")
    @OneToOne
    private Patient patient;

    @JoinColumn(name="test_id")
    @OneToOne
    private TestPatient testPatient;
    private String testDate;
    private String testDescription;

    protected TestResults(){}

    private TestResults(Builder builder) {
        this.testResultsID = builder.testResultsID;
        this.patient = builder.patient;
        this.testPatient = builder.testPatient;
        this.testDate = builder.testDate;
        this.testDescription = builder.testDescription;
    }



    public void setTestResultsID(String testResultsID) {
        this.testResultsID = testResultsID;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setTestPatient(TestPatient testPatient) {
        this.testPatient = testPatient;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    @Override
    public String toString() {
        return "TestResults{" +
                "testResultsID'" + testResultsID + '\''+
                "patient='" + patient + '\'' +
                ", testPatient='" + testPatient + '\'' +
                ", testDate='" + testDate + '\'' +
                ", testDescription='" + testDescription + '\'' +
                '}';
    }

    public static class Builder {

        private String testResultsID;
        private Patient patient;

        private TestPatient testPatient;
        private String testDate;
        private String testDescription;

            public Builder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }
        public Builder setTestResultsID(String testResultsID) {
            this.testResultsID = testResultsID;
            return this;
        }

        public Builder setTestPatient(TestPatient testPatient) {
            this.testPatient = testPatient;
            return this;
        }

        public Builder setTestDate(String testDate) {
            this.testDate = testDate;
            return this;
        }

        public Builder setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }

        public Builder copy(TestResults testresults) {
            this.testResultsID = testResultsID;
            this.patient = testresults.patient;
            this.testPatient = testPatient;
            this.testDate = testresults.testDate;
            this.testDescription = testresults.testDescription;
            return this;
        }
        public TestResults build() {
            return new TestResults(this);
        }
    }
}