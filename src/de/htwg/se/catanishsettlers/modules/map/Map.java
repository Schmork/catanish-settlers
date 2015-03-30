package de.htwg.se.catanishsettlers.modules.map;

/**
 * Map manages the fields, edges and vertices of the board. It knows to which field each vetix or edge belongs.
 * Created by JonnyTieM on 29.03.2015.
 */
public class Map {
    private Field[][] fields;
    private Edge[][] edges;
    private Vertex[][] vertices;

    /**
     * standard Map for catanish Settlers
     */
    public Map() {
        fields = new Field[5][5];
        vertices = new Vertex[6][12];
    }
}
