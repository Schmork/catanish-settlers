package de.htwg.se.catanishsettlers.modules.mechanic;

import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;

/**
 * Created by Stephan on 02.04.2015.
 */
public abstract class Investment {
    protected static ResourceCollection cost;

    public static ResourceCollection getCost() {
        return cost;
    }
}
