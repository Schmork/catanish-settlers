package de.htwg.se.catanishsettlers.modules.map;

/**
 * Map manages the fields, edges and vertices of the board. It knows to which field each vetix or edge belongs.
 * <p>
 * Some inspiration for this class is taken from following links:
 * http://www.redblobgames.com/grids/hexagons/
 * http://stackoverflow.com/questions/5040295/data-structure-for-settlers-of-catan-map
 * Created by JonnyTieM on 29.03.2015.
 */
public final class Map implements IMap {
    private Field[][] fields;
    private Edge[][] edges;
    private Vertex[][] vertices;

    public Map() {
        initStandardMap();
    }

    /**
     * standard Map for catanish Settlers
     */
    private void initStandardMap() {
        fields = new Field[5][5];
        edges = new Edge[6][17];
        vertices = new Vertex[6][12];

    }

    private void createField(int x, int y) {

    }

    @Override
    public Edge[] getEdges(Field field) {
        int x = field.getX();
        int y = field.getY();

        // Create edges array, where we put in all the edges of the field and then return it.
        Edge[] edges = new Edge[6];

        if (x % 2 == 0) {

        } else {

        }

        return edges;
    }

    @Override
    public Vertex[] getVertices(Field field) {
        if (field == null) {
            return null;
        }

        int x = field.getX();
        int y = field.getY();

        // Create vertex array, where we put in all the vertices of the field and then return it.
        Vertex[] vertices = new Vertex[6];

        if (x % 2 == 0) {
            vertices[0] = this.vertices[x][2 * y]; //top left
            vertices[1] = this.vertices[x + 1][2 * y]; // top right
            vertices[2] = this.vertices[x + 1][2 * y + 1]; // middle right
            vertices[3] = this.vertices[x + 1][2 * y + 2]; // bottom right
            vertices[4] = this.vertices[x][2 * y + 2]; // bottom left
            vertices[5] = this.vertices[x][2 * y + 1]; // middle left
        } else {
            vertices[0] = this.vertices[x][2 * y + 1]; //top left
            vertices[1] = this.vertices[x + 1][2 * y + 1]; // top right
            vertices[2] = this.vertices[x + 1][2 * y + 2]; // middle right
            vertices[3] = this.vertices[x + 1][2 * y + 3]; // bottom right
            vertices[4] = this.vertices[x][2 * y + 3]; // bottom left
            vertices[5] = this.vertices[x][2 * y + 2]; // middle left
        }

        return vertices;
    }

    @Override
    public Field[] getAdjacentFields(Vertex vertex) {
        return new Field[0];
    }

    @Override
    public Vertex[] getNeighbouringVertices(Vertex vertex) {
        return new Vertex[0];
    }
}
