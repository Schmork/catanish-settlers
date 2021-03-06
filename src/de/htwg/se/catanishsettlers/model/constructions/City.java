package de.htwg.se.catanishsettlers.model.constructions;

import de.htwg.se.catanishsettlers.model.map.Vertex;
import de.htwg.se.catanishsettlers.model.mechanic.Player;
import de.htwg.se.catanishsettlers.model.resources.ResourceCollection;

/**
 * Created by Stephan on 01.04.2015.
 */
public final class City extends Building{
    public City(Player player, Vertex vertex) {
        super(player, vertex);
        cost = new ResourceCollection(0, 0, 0, 3, 2);
        owner = player;
        score = 2;
        yield = 2;
    }
}
