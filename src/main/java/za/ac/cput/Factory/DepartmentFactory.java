/*  DepartmentFactory.java
    Factory for the Department
    Author: Chante Lee Davids [220246688]
    Date  : 6 August 2022
*/

package za.ac.cput.Factory;

import za.ac.cput.Entity.Department;
import za.ac.cput.util.Helper;

public class DepartmentFactory {

    public static Department createDepartment(String departmentID, String departmentName, int departmentSize){

        // String departmentID = Helper.generateDepartmentID();

        return new Department.Builder()
                .setDepartmentID(departmentID)
                .setDepartmentName(departmentName)
                .setDepartmentSize(departmentSize)
                .build();
    }

}