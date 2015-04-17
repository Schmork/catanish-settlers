package de.htwg.se.catanishsettlers.modules.constructions;

import de.htwg.se.catanishsettlers.modules.map.Edge;
import de.htwg.se.catanishsettlers.modules.map.Vertex;
import de.htwg.se.catanishsettlers.modules.mechanic.Player;
import de.htwg.se.catanishsettlers.modules.resources.Brick;
import de.htwg.se.catanishsettlers.modules.resources.Lumber;
import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;

/**
 * Created by Stephan on 01.04.2015.
 */
public final class Road extends Construction {

    public Road(Player player, Edge edge) {
        super(player, edge);
        cost = new ResourceCollection(new Brick(2),new Lumber(1));
    }
}
