package de.htwg.se.catanishsettlers.modules.constructions;

import de.htwg.se.catanishsettlers.modules.map.MapObject;
import de.htwg.se.catanishsettlers.modules.map.Vertex;
import de.htwg.se.catanishsettlers.modules.mechanic.Player;
import de.htwg.se.catanishsettlers.modules.resources.Resource;
import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;

/**
 * Created by Stephan on 02.04.2015.
 */
public abstract class Building extends Construction{
    protected int score;    // this value determines both the score for victory as well as resource gathering efficiency
    private ResourceCollection collectedResources;    // temporal storage for resources from fields

    public Building(Player player, Vertex vertex) {
        super(player, vertex);
        collectedResources = new ResourceCollection();
    }

    public int getScore() {
        return score;
    }

    //  this method is meant to be called from a Field that was triggered by dice roll
    public ResourceCollection harvestField(Resource resource) {
        for (int n = 0; n < score; n++) collectedResources.add(resource);   // 1 for settlement, 2 for city
        //new Message(this.toString() + " collected " + resource.toString());
        return collectedResources;
    }

    // this method returns the resources that have been collected by harvestField().
    // important: FIRST call harvestField(), THEN call collectResources()
    public ResourceCollection collectResources() {
        ResourceCollection temp = collectedResources;
        collectedResources = new ResourceCollection();   // deplete depot
        return temp;
    }
}
