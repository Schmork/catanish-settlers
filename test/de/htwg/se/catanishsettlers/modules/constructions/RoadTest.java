package de.htwg.se.catanishsettlers.modules.constructions;

import de.htwg.se.catanishsettlers.modules.constructions.Road;
import de.htwg.se.catanishsettlers.modules.mechanic.Game;
import de.htwg.se.catanishsettlers.modules.mechanic.Player;
import de.htwg.se.catanishsettlers.modules.resources.Brick;
import de.htwg.se.catanishsettlers.modules.resources.Lumber;
import de.htwg.se.catanishsettlers.modules.resources.Resource;
import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoadTest {

    Road testRoad;
    Player testPlayer = new Player("test name");

    @Test
    public void setUp() throws Exception {
        testRoad = new Road(testPlayer);

        ResourceCollection roadCost = new ResourceCollection(new Brick(2), new Lumber(1));
        assertEquals(testRoad.getCost().compareTo(roadCost), 0);
    }
}