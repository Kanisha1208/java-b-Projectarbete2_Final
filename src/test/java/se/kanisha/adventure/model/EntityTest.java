package se.kanisha.adventure.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EntityTest
{

    Resident resident;
    Burglar burglar;


    @BeforeEach
    void setUp()
    {
        resident = new Resident("Resident", 12, 3); // Assign to instance variable
        burglar = new Burglar("Burglar", 12, 4);    // Assign to instance variable
    }



    @Test
    void takeHitTest()
    {
        burglar.takeHit(4);
        assertEquals(8, burglar.getHealth());
    }



    @Test
    void isConsciousTest()
    {
        assertTrue(resident.isConscious());
        assertTrue(burglar.isConscious());
    }


    @Test
    void isConsciousTest1()
    {
        resident=new Resident("Resident", 12, 6);
        burglar=new Burglar("Burglar", 6, 4);
        resident.punch(burglar);
        assertFalse(burglar.isConscious());

    }

    @Test
    void isConsciousTest2()
    {
        resident = new Resident("Resident", 12, 6);
        burglar = new Burglar("Burglar", 8, 4);
        resident.punch(burglar);
        assertTrue(burglar.isConscious());

    }


    @Test
    void punchTest()
    {
        resident.punch(burglar);
        assertEquals(9,burglar.getHealth());
    }



    @Test
    void testPunch()
    {
        burglar.punch(resident);
        assertEquals(8,resident.getHealth());
    }
}