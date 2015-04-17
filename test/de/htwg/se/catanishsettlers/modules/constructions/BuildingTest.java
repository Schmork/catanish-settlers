package de.htwg.se.catanishsettlers.modules.constructions;

import de.htwg.se.catanishsettlers.modules.constructions.Building;
import de.htwg.se.catanishsettlers.modules.constructions.City;
import de.htwg.se.catanishsettlers.modules.constructions.Settlement;
import de.htwg.se.catanishsettlers.modules.mechanic.Player;
import de.htwg.se.catanishsettlers.modules.resources.*;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class BuildingTest {

    Building testSettlement, testCity;
    Resource testResourceType;

    @Before
    public void setUp() throws Exception {
        Player player = new Player("hans");
        testSettlement = new Settlement(player);
        testCity = new City(player);

        testResourceType = new Grain(1);
    }

    @Test
    public void testGetScore() throws Exception {
        assertEquals(testSettlement.getScore(), 1);
        assertEquals(testCity.getScore(), 2);
    }

    @Test
    public void testHarvestField() throws Exception {
        ResourceCollection testResource;

        testResource = testSettlement.harvestField(testResourceType);
        assertEquals(testResource.getGrain().getAmount(), testSettlement.getScore());
        assertEquals(testResource.getOre().getAmount(), 0);

        testResource = testCity.harvestField(testResourceType);
        assertEquals(testResource.getGrain().getAmount(), testCity.getScore());
        assertEquals(testResource.getOre().getAmount(), 0);
    }

    @Test
    public void testCollectResources() throws Exception {
        ResourceCollection testResource, compareResource;

        testResource = new ResourceCollection(new Brick(2), new Wool(2), new Ore(4));

        testSettlement.harvestField(new Brick(1));
        testSettlement.harvestField(new Brick(1));

        testSettlement.harvestField(new Wool(1));
        testSettlement.harvestField(new Wool(1));

        testSettlement.harvestField(new Ore(1));
        testSettlement.harvestField(new Ore(1));
        testSettlement.harvestField(new Ore(1));
        testSettlement.harvestField(new Ore(1));

        compareResource = testSettlement.collectResources();
        assertEquals(testResource.compareTo(compareResource), 0);


        testCity.harvestField(new Brick(1));

        testCity.harvestField(new Wool(1));

        testCity.harvestField(new Ore(1));
        testCity.harvestField(new Ore(1));

        compareResource = testCity.collectResources();
        assertEquals(testResource.compareTo(compareResource), 0);
    }
}