package de.htwg.se.catanishsettlers.modules.map;

/**
 * Map manages the fields, edges and vertices of the board. It knows to which field each vetix or edge belongs.
 *
 * Some inspiration for this class is taken from following links:
 * http://www.redblobgames.com/grids/hexagons/
 * http://stackoverflow.com/questions/5040295/data-structure-for-settlers-of-catan-map
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
