package de.htwg.se.catanishsettlers.modules.constructions;

import de.htwg.se.catanishsettlers.modules.map.Vertex;
import de.htwg.se.catanishsettlers.modules.mechanic.Player;
import de.htwg.se.catanishsettlers.modules.resources.Grain;
import de.htwg.se.catanishsettlers.modules.resources.Ore;
import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;

/**
 * Created by Stephan on 01.04.2015.
 */
public final class City extends Building{
    public City(Player player, Vertex vertex) {
        super(player, vertex);
        cost = new ResourceCollection(new Grain(3), new Ore(2));
        owner = player;
        score = 2;
    }
}
