package de.htwg.se.catanishsettlers.modules.map;

import de.htwg.se.catanishsettlers.modules.constructions.Building;

/**
 * Created by JonnyTieM on 29.03.2015.
 */
public class Vertex extends MapObject {

    private Building building = null;

    public Vertex(int x, int y) {
        super(x, y);
    }

    public void placeBuilding(Building newBuilding) { building = newBuilding; }
    public Building getBuilding() { return  building; }
}
