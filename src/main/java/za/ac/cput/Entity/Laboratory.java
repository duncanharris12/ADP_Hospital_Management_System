package za.ac.cput.Entity;

//This is a worker class for laboratory entity under entity package.
//In this class will implement an entity called Laboratory using a builder pattern.
//Laboratory.Java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 06 April 2022
 */

@Setter
@Getter

@AllArgsConstructor
@Table
@Entity

public class Laboratory {
//Declaring all the  private fields we are going to use on our program

    @Id
    @Column(name = "labID")

    private String labID;

    @Column(name= "patient_id")
    @OneToOne
    private Patient pat;

    @Column (name = "doctor_id")
    @OneToOne
    private Doctor doctor;

    @Column(name = "test_id")
    @OneToOne
    private TestPatient testPatient;

    @NotNull
    private String labName;
    @NotNull
    private String labDay;
    @NotNull
    private double amount;

    protected Laboratory(){

    }

//Creating a private parameterized constructor

    private Laboratory (Builder builder){

        this.labID  = builder.labID;
        this.doctor = builder.build().doctor;
        this.pat = builder.build().pat;
        this.testPatient = builder.build().testPatient;
        this.labName = builder.labName;
        this.labDay = builder.labDay;
        this.amount = builder.amount;


    }

    public String getLabID() {
        return labID;
    }

    public Patient getPatient() {
        return pat;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public TestPatient getTestPatient() {
        return testPatient;
    }

    public String getLabName() {
        return labName;
    }

    public String getLabDay() {
        return labDay;
    }

    public double getAmount() {
        return amount;
    }



    @Override
    public String toString() {
        return "Laboratory{" +
                "labId='" + labID + '\'' +
                ", patientId='" + pat + '\'' +
                ", doctorId='" + doctor + '\'' +
                ", patientTestId='" + testPatient + '\'' +
                ", labName='" + labName + '\'' +
                ", labDate=" + labDay +
                ", amount=" + amount +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laboratory laboratory = (Laboratory) o;
        return labID.equals(laboratory.labID) && pat.equals(laboratory.pat)
                && doctor.equals(laboratory.doctor) && testPatient.equals(laboratory.testPatient)
                && labName.equals(laboratory.labName) && labDay.equals(laboratory.labDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labID);
    }




    public static class Builder{

        private String labID;
        private Patient pat;
        private Doctor doctor;
        private TestPatient testPatient;
        private String labName;
        private String labDay;
        private double amount;


        public Builder setLabID (String labID1){
            this.labID = labID1;
            return this;
        }
        public Builder setPatient (Patient pat){
            this.pat = pat;
            return this;
        }

        public Builder setDoctor (Doctor doctor){
            this.doctor = doctor;
            return this;
        }

        public Builder setTestPatient (TestPatient testPatient){
            this.testPatient = testPatient;
            return this;
        }

        public Builder setLabName (String labName1){
            this.labName = labName1;
            return this;
        }

        public Builder setLabDay (String labDay1){
            this.labDay = labDay1;
            return this;
        }

        public Builder setAmount (double amount1){
            this.amount = amount1;
            return this;
        }

        public Builder Copy (Laboratory laboratory){

            this.labID = laboratory.labID;
            this.pat = laboratory.pat;
            this.doctor = laboratory.doctor;
            this.testPatient = laboratory.testPatient;
            this.labName = laboratory.labName;
            this.labDay = laboratory.labDay;
            this.amount = laboratory.amount;

            return this;
        }


        public Laboratory build(){
            return new Laboratory(this);
        }

    }

}