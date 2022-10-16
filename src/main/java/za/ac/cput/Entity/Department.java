/*  Department.java
    Entity for the Department
    Author: Chante Lee Davids [220246688]
    Date  : 6 August 2022
*/

package za.ac.cput.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Department implements Serializable {

    @Id
    @Column(name = "department_id")
    private String departmentID;

    @NotNull
    private String departmentName;

    @NotNull
    private int departmentSize;

    @OneToMany(mappedBy = "department")
    private List<Doctor> doctors;

    protected Department() {
    }

    private Department(Builder builder){
        this.departmentID = builder.departmentID;
        this.departmentName = builder.departmentName;
        this.departmentSize = builder.departmentSize;
    }

    //getters
    public String getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepartmentSize() {
        return departmentSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department department = (Department) o;
        return Objects.equals(departmentID, department.departmentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentID);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentSize=" + departmentSize +
                '}';
    }

    public static class Builder {
        private String departmentID;
        private String departmentName;
        private int departmentSize;

        public Builder setDepartmentID(String departmentID) {
            this.departmentID = departmentID;
            return this;
        }

        public Builder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder setDepartmentSize(int departmentSize) {
            this.departmentSize = departmentSize;
            return this;
        }

        public Builder copy(Department department) {
            this.departmentID = department.departmentID;
            this.departmentName = department.departmentName;
            this.departmentSize = department.departmentSize;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}