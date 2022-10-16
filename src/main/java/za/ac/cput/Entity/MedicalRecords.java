/* MedicalRecords.java
   Entity for the medicalRecords(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class MedicalRecords implements Serializable
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "")
    private String recordID;
    @ManyToOne
    @JoinColumn(name = "testID", referencedColumnName = "testID")
    private TestResults testResults;

    protected MedicalRecords(){}

    private MedicalRecords(Builder builder)
    {
       this.recordID = builder.recordID;
       this.testResults = builder.testResults;
            
    }
    
    public String getRecordID() {
        return recordID;
    }

    public TestResults getTestResults() {
        return testResults;
    }

    @Override
    public String toString() {
        return "MedicalRecords{" +
                "recordID='" + recordID + '\'' +
                ", testResults=" + testResults +
                '}';
    }

    public static class Builder
    {
        private String recordID;
        private TestResults testResults;

        public Builder setRecordID(String recordID) {
            this.recordID = recordID;
            return this;
        }

        public Builder setTestResults(TestResults testResults) {
            this.testResults = testResults;
            return this;
        }

        public Builder copy(MedicalRecords medicalrecords)
        {
            this.recordID = medicalrecords.recordID;
            this.testResults = medicalrecords.testResults;
            
            return this;
        }
        
        public MedicalRecords build()
        {
            return new MedicalRecords(this);
        }
    }

//    @Override
//    public boolean equals(Object obj)
//    {
//        if(this == obj)
//            return true;
//        if(obj == null || getClass() != obj.getClass())
//            return false;
//        MedicalRecords medicalRecords = (MedicalRecords) obj;
//        return recordID.equals(medicalRecords.recordID);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(recordID);
//    }
}
