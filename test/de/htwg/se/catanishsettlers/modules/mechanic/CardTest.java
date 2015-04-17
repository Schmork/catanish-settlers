package de.htwg.se.catanishsettlers.modules.mechanic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    Card testCard;

    @Before
    public void setUp() throws Exception {
        testCard = new Card(Card.Types.VICTORYPOINT);
    }

    @Test
    public void testGetType() throws Exception {
        assertEquals(testCard.getType(), Card.Types.VICTORYPOINT);
    }
}