package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Receptionist;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistFactoryTest
{
    @Test
    void createReceptionist()
    {
        Receptionist receptionist = ReceptionistFactory.createReceptionist("Davin", "Valory", 1232242);
        assertNotNull(receptionist);
        System.out.println(receptionist);
    }
}