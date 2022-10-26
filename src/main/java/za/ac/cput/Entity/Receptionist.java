package za.ac.cput.Entity;
/* Receptionist.java
   Entity for the Receptionist(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Receptionist implements Serializable
{
    @Id
    @Column(name = "receptionist_id")
    private String receptionistID;
    @NotNull
    private String receptionistUserName;
    @NotNull
    private String receptionistPassword;
    @NotNull
    private long receptionistTelephoneNumber;
    public Receptionist() {// CHANGED IT TO PUBLIC FOR GUI, CHANGE TO PROTECTED IF YOU RUN INTO ISSUES
    }

    private Receptionist(Builder builder)
    {
        this.receptionistID = builder.receptionistID;
        this.receptionistUserName = builder.receptionistUserName;
        this.receptionistPassword = builder.receptionistPassword;
        this.receptionistTelephoneNumber = builder.receptionistTelephoneNumber;
    }

    public String getReceptionistID()
    {
        return receptionistID;
    }

    public String getReceptionistUserName()
    {
        return receptionistUserName;
    }

    public String getReceptionistPassword()
    {
        return receptionistPassword;
    }

    public long getReceptionistTelephoneNumber()
    {
        return receptionistTelephoneNumber;
    }

    @Override
    public String toString()
    {
        return "Receptionist{" +
                "receptionistID=" + receptionistID +
                ", receptionistName='" + receptionistUserName + '\'' +
                ", receptionistPassword='" + receptionistPassword + '\'' +
                ", receptionistTelephoneNumber=" + receptionistTelephoneNumber +
                '}';
    }

    public static class Builder
    {
        private String receptionistID;
        private String receptionistUserName;
        private String receptionistPassword;
        private long receptionistTelephoneNumber;

        public Builder setReceptionistID(String receptionistID) {
            this.receptionistID = receptionistID;
            return this;
        }

        public Builder setReceptionistUserName(String receptionistUserName) {
            this.receptionistUserName = receptionistUserName;
            return this;
        }

        public Builder setReceptionistPassword(String receptionistPassword) {
            this.receptionistPassword = receptionistPassword;
            return this;
        }

        public Builder setReceptionistTelephoneNumber(long receptionistTelephoneNumber) {
            this.receptionistTelephoneNumber = receptionistTelephoneNumber;
            return this;
        }

        public Builder copy(Receptionist receptionist)
        {
            this.receptionistID = receptionist.receptionistID;
            this.receptionistUserName = receptionist.receptionistUserName;
            this.receptionistPassword = receptionist.receptionistPassword;
            this.receptionistTelephoneNumber = receptionist.receptionistTelephoneNumber;
            return this;
        }
        public Receptionist build()
        {
            return new Receptionist(this);
        }
    }
}
