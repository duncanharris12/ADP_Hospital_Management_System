/*  DoctorFactory.java
    Factory for the Doctor
    Author: Chante Lee Davids [220246688]
    Date  : 6 August 2022
*/

package za.ac.cput.Factory;


import za.ac.cput.Entity.Department;
        import za.ac.cput.Entity.Doctor;
        import za.ac.cput.util.Helper;

public class DoctorFactory {
    public static Doctor createDoctor(String doctorID, String doctorName, String doctorPassword,
                                      Department department,
                                      String specialty)
    {
        //String doctorID = Helper.generateDoctorID();

        return new Doctor.Builder()
                .setDoctorID(doctorID)
                .setDoctorName(doctorName)
                .setDoctorPassword(doctorPassword)
                .setDepartment(department)
                .setSpecialty(specialty)
                .build();
    }
}