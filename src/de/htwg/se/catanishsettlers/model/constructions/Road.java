package de.htwg.se.catanishsettlers.model.constructions;

import de.htwg.se.catanishsettlers.model.map.Edge;
import de.htwg.se.catanishsettlers.model.mechanic.Player;
import de.htwg.se.catanishsettlers.model.resources.ResourceCollection;

/**
 * Created by Stephan on 01.04.2015.
 */
public final class Road extends Construction {
    private Edge edge;

    public Road(Player player, Edge edge) {
        super(player, edge);
        cost = new ResourceCollection(2, 1, 0, 0, 0);
        this.edge = edge;
    }
}
