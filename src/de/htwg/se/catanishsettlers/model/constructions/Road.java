package de.htwg.se.catanishsettlers.model.constructions;

import de.htwg.se.catanishsettlers.model.map.Edge;
import de.htwg.se.catanishsettlers.model.mechanic.Player;
import de.htwg.se.catanishsettlers.model.resources.Brick;
import de.htwg.se.catanishsettlers.model.resources.Lumber;
import de.htwg.se.catanishsettlers.model.resources.ResourceCollection;

/**
 * Created by Stephan on 01.04.2015.
 */
public final class Road extends Construction {

    public Road(Player player, Edge edge) {
        super(player, edge);
        cost = new ResourceCollection(new Brick(2),new Lumber(1));
        edge.buildRoad(this);
    }
}
