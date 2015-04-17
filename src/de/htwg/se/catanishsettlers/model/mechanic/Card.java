package de.htwg.se.catanishsettlers.model.mechanic;

import de.htwg.se.catanishsettlers.model.resources.ResourceCollection;
import de.htwg.se.catanishsettlers.model.resources.Grain;
import de.htwg.se.catanishsettlers.model.resources.Ore;
import de.htwg.se.catanishsettlers.model.resources.Wool;

/**
 * Created by Stephan on 01.04.2015.
 */
public class Card extends Investment {

    public enum Types {
        KNIGHT,
        PROGRESS_MONOPOLY,
        PROGRESS_ROAD_CONSTRUCTION,
        PROGRESS_DEVELOPMENT,
        VICTORYPOINT
    }

    private Types type;

    public Card(Types type) {
        this.type = type;
        cost = new ResourceCollection(new Wool(1), new Grain(1), new Ore(1));
    }

    public Types getType() {
        return type;
    }
}
