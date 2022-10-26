package za.ac.cput.Entity;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 TestPatient.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 Date: 07 August 2022
 **/


@Getter
@Entity
public class TestPatient implements Serializable {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_id")
    private String testID;

    @NotNull
    private String testName;




    @OneToMany(mappedBy = "testPatient")
    private List<Patient> patient;
    protected TestPatient(){
    }



    private TestPatient(Builder builder) {
        this.testID = builder.testID;
        this.testName = builder.testName;

    }


    @Override
    public String toString() {
        return "TestPatient{" +
                "testID='" + testID + '\'' +
                ", testName='" + testName + '\'' +
                ", patient='" + patient + '\'' +
                '}';
    }



    public static class Builder{
        private String testID;
        private String testName;
        private Patient patient;


        public Builder setTestID(String testID) {
            this.testID = testID;
            return this;
        }

        public Builder setTestName(String testName) {
            this.testName = testName;
            return this;
        }

        public Builder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder copy(TestPatient testPatient){
            this.testID = testPatient.testID;
            this.testName = testPatient.testName;
            this.patient = patient;
            return this;
        }

        public TestPatient build(){
            return new TestPatient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestPatient testPatient = (TestPatient) o;
        return testID.equals( testPatient.testID) ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(testID);
    }
}
