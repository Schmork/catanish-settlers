package de.htwg.se.catanishsettlers.model.map;

import de.htwg.se.catanishsettlers.model.constructions.Building;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

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

    public List<Field> getSurroundingFields() {
        throw new NotImplementedException(); // TODO: implement getFields(vertex)
    }
}
