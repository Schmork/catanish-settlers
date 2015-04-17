package de.htwg.se.catanishsettlers.modules.mechanic;

import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;
import de.htwg.se.catanishsettlers.modules.resources.Grain;
import de.htwg.se.catanishsettlers.modules.resources.Ore;
import de.htwg.se.catanishsettlers.modules.resources.Wool;
import de.htwg.se.catanishsettlers.modules.view.IGenerateMessages;
import de.htwg.se.catanishsettlers.modules.view.Message;

import java.util.List;

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
