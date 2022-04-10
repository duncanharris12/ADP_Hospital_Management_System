/* AdministrationFactoryTest.java
   Factory Test for the administration
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Entity.Administration;

public class AdministrationFactoryTest 
{
    @Test
    void createAdministration()
    {
        Administration administration = AdministrationFactory.createAdministration
                                        ("Duncan", "Password");
        assertNotNull(administration);
        System.out.println(administration);
    }
    
}
