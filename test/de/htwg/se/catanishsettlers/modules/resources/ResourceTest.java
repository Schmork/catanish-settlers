package de.htwg.se.catanishsettlers.modules.resources;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResourceTest {
    int amount = 7;
    Resource testResource;

    @Before
    public void setUp() throws Exception {
        testResource = new Wool(amount);
    }

    @Test
    public void testGetAmount() throws Exception {
        setUp();
        assertEquals(testResource.getAmount(), amount);
    }

    @Test
    public void testAdd() throws Exception {
        setUp();

        testResource.add(3);
        assertEquals(testResource.getAmount(), 10);

        testResource.add(new Wool(5));
        assertEquals(testResource.getAmount(), 15);
    }

    @Test
    public void testSubtract() throws Exception {
        setUp();

        testResource.subtract(3);
        assertEquals(testResource.getAmount(), 4);

        testResource.subtract(new Wool(2));
        assertEquals(testResource.getAmount(), 2);

    }

    @Test
    public void testIsPositive() throws Exception {
        setUp();
        assertTrue(testResource.isPositive());

        testResource.subtract(9);
        assertFalse(testResource.isPositive());

        setUp();
        testResource.subtract(new Wool(8));
        assertFalse(testResource.isPositive());
    }
}