package za.ac.cput.Entity;


import lombok.Getter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/*
 Patient.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 Date: 07 August 2022
 */


@Getter
@Entity
public class Patient implements Serializable {


    @Id
   //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "patient_id")
    private String patientID;
    @NotNull
    private String patientName;
    @NotNull
    private String address;
    @NotNull
    private long phone_number;
    @NotNull
    private String sex;
    @NotNull
    private int age;
    @NotNull
    private String patientPassword;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TestPatient testPatient;
    protected Patient(){
    }




    private Patient(Builder builder){
        this.patientID = builder.patientID;
        this.patientName = builder.patientName;
        this.address = builder.address;
        this.phone_number = builder.phone_number;
        this.sex = builder.sex;
        this.age = builder.age;
        this.patientPassword = builder.patientPassword;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "patientID='" + patientID + '\'' +
                ", patientName='" + patientName + '\'' +
                ", address='" + address + '\'' +
                ", phone_number=" + phone_number +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", patientPassword='" + patientPassword + '\'' +
                '}';
    }




    public static class Builder{
        private String patientID;
        private String patientName;
        private String address;
        private long phone_number;
        private String sex;
        private int age;
        private String patientPassword;

        public Builder setPatientID(String patientID) {
            this.patientID = patientID;
            return this;
        }

        public Builder setPatientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone_number(long phone_number) {
            this.phone_number = phone_number;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPatientPassword(String patientPassword) {
            this.patientPassword = patientPassword;
            return this;
        }
        public Builder copy(Patient patient){
            this.patientID = patient.patientID;
            this.patientName = patient.patientName;
            this.address = patient.address;
            this.phone_number = patient.phone_number;
            this.sex = patient.sex;
            this.age = patient.age;
            this.patientPassword = patient.patientPassword;
            return this;
        }
        public Patient build(){

            return new Patient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientID.equals(patient.patientID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientID);
    }
}
