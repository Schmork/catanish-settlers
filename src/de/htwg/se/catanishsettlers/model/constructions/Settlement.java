package de.htwg.se.catanishsettlers.model.constructions;

import de.htwg.se.catanishsettlers.model.map.Vertex;
import de.htwg.se.catanishsettlers.model.mechanic.Player;
import de.htwg.se.catanishsettlers.model.resources.*;

/**
 * Created by Stephan on 01.04.2015.
 */
public final class Settlement extends Building{
    public Settlement(Player player, Vertex vertex) {
        super(player, vertex);
        cost = new ResourceCollection(new Brick(1), new Lumber(1), new Wool(1), new Grain(1));
        score = 1;
        yield = 1;
    }
}
