package de.htwg.se.catanishsettlers.model.constructions;

import de.htwg.se.catanishsettlers.model.map.Vertex;
import de.htwg.se.catanishsettlers.model.mechanic.Player;
import de.htwg.se.catanishsettlers.model.map.Field;
import de.htwg.se.catanishsettlers.model.resources.Resource;
import de.htwg.se.catanishsettlers.model.resources.ResourceCollection;

/**
 * Created by Stephan on 02.04.2015.
 */
public abstract class Building extends Construction{
    protected int score;    // how many victory points?
    protected int yield;    // how many resources gathered?
    private ResourceCollection collectedResources;    // temporal storage for resources from fields

    public Building(Player player, Vertex vertex) {
        super(player, vertex);
        collectedResources = new ResourceCollection();
        vertex.placeBuilding(this);
    }

    public int getScore() {
        return score;
    }

    public Resource amplify(Resource resource) {
        return resource.multiply(yield);
    }

    public ResourceCollection yieldResources() {
        ResourceCollection collectedResources = new ResourceCollection();

        Vertex vertex = (Vertex)getPosition();
        for(Field surroundingField : vertex.getSurroundingFields()) {
            Resource resource = surroundingField.getResource();
            resource.multiply(yield);
            collectedResources.add(resource);
        }
        return collectedResources;
    }
}
