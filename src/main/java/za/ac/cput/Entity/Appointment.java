package za.ac.cput.Entity;

//This is a worker class for Appointment entity under entity package.
//In this class will implement an entity called Appointment using a builder pattern.
//Appointment.Java


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 06 April 2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Appointment {
    //Declaring all the fields for the program as private fields
    @Id
    @Column(name = "appointmentID")
    private String appointmentID;


    @JoinColumn(name = "doctor_id")
    @OneToOne
    private Doctor doctor;

    @NotNull
    private String appointmentType;
    @NotNull
    private String appointmentDescription;
    @NotNull


    private String appointmentDay;
    @NotNull
    private String appointmentMonth;

//Creating a private parametrized constructor

    private Appointment(Builder builder) {
        this.appointmentID = builder.appointmentID;
        this.doctor = builder.build().doctor;
        this.appointmentType = builder.appointmentType;
        this.appointmentDescription = builder.appointmentDescription;
        this.appointmentDay = builder.appointmentDay;
        this.appointmentMonth = builder.appointmentMonth;


    }


    public String getAppointmentID() {
        return appointmentID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public String getAppointmentDay() {
        return appointmentDay;
    }

    public String getAppointmentMonth() {
        return appointmentMonth;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentID + '\'' +
                ", doctorId='" + doctor + '\'' +
                ", appointmentType='" + appointmentType + '\'' +
                ", appointmentDescription='" + appointmentDescription + '\'' +
                ", appointmentDate=" + appointmentDay +
                ", appointmentTime=" + appointmentMonth +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Appointment appointment = (Appointment) obj;
        return appointmentID.equals(appointment.appointmentID) && doctor.equals(appointment.doctor)
                && appointmentType.equals(appointment.appointmentType) && appointmentDescription.equals(appointment.appointmentDescription)
                && appointmentDay.equals(appointment.appointmentDay) && appointmentMonth.equals(appointment.appointmentMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentID);
    }


    public static class Builder {
        //Declaring all the fields for the program as private fields

        private String appointmentID;
        private Doctor doctor;
        private String appointmentType;
        private String appointmentDescription;
        private String appointmentDay;
        private String appointmentMonth;


        public Builder setAppointmentId(String appointmentID1) {
            this.appointmentID = appointmentID1;
            return this;
        }

        public Builder setDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public Builder setAppointmentType(String appointmentType1) {
            this.appointmentType = appointmentType1;
            return this;
        }

        public Builder setAppointmentDescription(String appointmentDescription1) {
            this.appointmentDescription = appointmentDescription1;
            return this;
        }

        public Builder setAppointmentDay(String appointmentDay1) {
            this.appointmentDay = appointmentDay1;
            return this;
        }

        public Builder setAppointmentMonth(String appointmentMonth1) {
            this.appointmentMonth = appointmentMonth1;
            return this;
        }


        public Builder Copy(Appointment appointment) {

            this.appointmentID = appointment.appointmentID;
            this.doctor = appointment.doctor;
            this.appointmentType = appointment.appointmentType;
            this.appointmentDescription = appointment.appointmentDescription;
            this.appointmentDay = appointment.appointmentDay;
            this.appointmentMonth = appointment.appointmentMonth;

            return this;

        }

        public Appointment build() {
            return new Appointment(this);
        }

    }

}
