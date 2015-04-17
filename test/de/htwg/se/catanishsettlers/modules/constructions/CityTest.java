package de.htwg.se.catanishsettlers.modules.constructions;

import de.htwg.se.catanishsettlers.modules.constructions.City;
import de.htwg.se.catanishsettlers.modules.mechanic.Player;
import de.htwg.se.catanishsettlers.modules.resources.Grain;
import de.htwg.se.catanishsettlers.modules.resources.Ore;
import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;
import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {

    City testCity;
    Player testPlayer = new Player("test name");

    @Test
    public void setUp() throws Exception {
        testCity = new City(testPlayer);

        assertEquals(testCity.getCost().compareTo(new ResourceCollection(new Grain(3), new Ore(2))), 0);
        assertEquals(testCity.getScore(), 2);
    }
}