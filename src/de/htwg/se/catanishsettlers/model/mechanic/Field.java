package de.htwg.se.catanishsettlers.model.mechanic;

import de.htwg.se.catanishsettlers.model.resources.*;

/**
 *
 * this is just a dummy class - the real Field.java is in the Map branch
 *
 * Created by Stephan on 01.04.2015.
 */
public class Field {
    private Resource resource;
    private int triggerNumber;

    public Field(Class type) {
        if (type == Brick.class) resource = new Brick(1);
        if (type == Lumber.class) resource = new Lumber(1);
        if (type == Wool.class) resource = new Wool(1);
        if (type == Grain.class) resource = new Grain(1);
        if (type == Ore.class) resource = new Ore(1);

        if (resource == null) throw new IllegalArgumentException("Only Brick, Lumber, Wool, Grain or Ore allowed");
    }

    public Class getType() {
        return resource.getClass();
    }

    public Resource getResource() {
        return  resource;
    }

    public int getTriggerNumber() {
        return triggerNumber;
    }
}
