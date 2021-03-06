package de.htwg.se.catanishsettlers.model.map;

import java.util.LinkedList;
import java.util.List;

/**
 * Map manages the fields, edges and vertices of the board. It knows to which field each vetix or edge belongs.
 * x coordinates start on the left with zero and go up towards the right.
 * y coordinates start on the top with zero and to up towards the bottom.
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

        createField(2, 0);
        createField(1, 0);
        createField(3, 0);
        for (int x = 0; x <= 4; x++) {
            for (int y = 1; y <= 3; y++) {
                createField(x, y);
            }
        }
        createField(2, 4);
    }

    /**
     * creates a Field at given Position.
     * Then it checks whether all the edges and vertices for this field already exist.
     * If not it will create the needed edges and vertices.
     *
     * @param x x-Position
     * @param y y-Position
     */
    private void createField(int x, int y) {
        fields[x][y] = new Field(x, y);
        Field field = fields[x][y];

        Edge[] fieldEdges = getEdges(field);
        Vertex[] fieldVertices = getVertices(field);

        for (int i = 0; i < 6; i++) {
            if (fieldEdges[i] == null) {
                int xEdge = getEdgesCoordinateX(field)[i];
                int yEdge = getEdgesCoordinateY(field)[i];
                edges[xEdge][yEdge] = new Edge(xEdge, yEdge);
            }

            if (fieldVertices[i] == null) {
                int xVertex = getVerticesCoordinateX(field)[i];
                int yVertex = getVerticesCoordinateY(field)[i];
                vertices[xVertex][yVertex] = new Vertex(xVertex, yVertex);
            }
        }
    }

    /**
     * Returns Field of given position. If x or y are negative, this will return null.
     *
     * @param x x-Coordinate
     * @param y y-Coordinate
     * @return Field at given position
     */
    public Field getField(int x, int y) {
        if (x < 0 || y < 0) {
            return null;
        }
        return fields[x][y];
    }

    public Edge getEdge(int x, int y) {
        if (x < 0 || y < 0) {
            return null;
        }
        return edges[x][y];
    }

    public Vertex getVertex(int x, int y) {
        if (x < 0 || y < 0) {
            return null;
        }
        return vertices[x][y];
    }

    @Override
    public Edge[] getEdges(Field field) {
        if (field == null) {
            return null;
        }

        // Create edges array, where we put in all the edges of the field and then return it.
        Edge[] edges = new Edge[6];

        int[] x = getEdgesCoordinateX(field);
        int[] y = getEdgesCoordinateY(field);

        edges[1] = this.edges[x[0]][y[0]]; // top
        edges[2] = this.edges[x[1]][y[1]]; // top right
        edges[3] = this.edges[x[2]][y[2]]; // bottom right
        edges[4] = this.edges[x[3]][y[3]]; // bottom
        edges[5] = this.edges[x[4]][y[4]]; // bottom left
        edges[6] = this.edges[x[5]][y[5]]; // top left

        return edges;
    }

    /**
     * returns the x coordinates of each Edge of the field in following order: top, top right, bottom right, bottom, bottom left, top left.
     *
     * @param field
     * @return
     */
    private int[] getEdgesCoordinateX(Field field) {
        int x = field.getX();

        int[] xEdge = new int[]{
                x, //top
                x + 1, // top right
                x + 1, // bottom right
                x, // bottom
                x, // bottom left
                x // top left
        };
        return xEdge;
    }

    /**
     * returns the y coordinates of each Edge of the field in following order: top, top right, bottom right, bottom, bottom left, top left.
     *
     * @param field
     * @return
     */
    private int[] getEdgesCoordinateY(Field field) {
        int x = field.getX();
        int y = field.getY();

        int[] yEdge;

        if (x % 2 == 0) {
            yEdge = new int[]{
                    3 * y, //top
                    3 * y + 1, // top right
                    3 * y + 2, // bottom right
                    3 * y + 3, // bottom
                    3 * y + 2, // bottom left
                    3 * y + 1 // top left
            };
        } else {
            yEdge = new int[]{
                    3 * y, //top
                    3 * y + 2, // top right
                    3 * y + 4, // bottom right
                    3 * y + 3, // bottom
                    3 * y + 4, // bottom left
                    3 * y + 2 // top left
            };
        }
        return yEdge;
    }

    @Override
    public Vertex[] getVertices(Field field) {
        if (field == null) {
            return null;
        }

        // Create vertex array, where we put in all the vertices of the field and then return it.
        Vertex[] vertices = new Vertex[6];

        int[] x = getVerticesCoordinateX(field);
        int[] y = getVerticesCoordinateY(field);

        vertices[0] = this.vertices[x[0]][y[0]]; // top left
        vertices[1] = this.vertices[x[1]][y[1]]; // top right
        vertices[2] = this.vertices[x[2]][y[2]]; // middle right
        vertices[3] = this.vertices[x[3]][y[3]]; // bottom right
        vertices[4] = this.vertices[x[4]][y[4]]; // bottom left
        vertices[5] = this.vertices[x[5]][y[5]]; // middle left

        return vertices;
    }

    /**
     * returns the x coordinates of each Vertex of the field in following order: top left, top right, middle right, bottom right, bottom left, middle left.
     *
     * @param field
     * @return
     */
    private int[] getVerticesCoordinateX(Field field) {
        int x = field.getX();

        int[] xVertex = new int[]{
                x,      //top left
                x + 1,  // top right
                x + 1,  // middle right
                x + 1,  // bottom right
                x,      // bottom left
                x       // middle left
        };
        return xVertex;
    }

    /**
     * returns the y coordinates of each Vertex of the field in following order: top left, top right, middle right, bottom right, bottom left, middle left.
     *
     * @param field
     * @return
     */
    private int[] getVerticesCoordinateY(Field field) {
        int x = field.getX();
        int y = field.getY();

        int[] yVertex;
        if (x % 2 == 0) {
            yVertex = new int[]{
                    2 * y,          //top left
                    2 * y,          // top right
                    2 * y + 1,      // middle right
                    2 * y + 2,      // bottom right
                    2 * y + 2,      // bottom left
                    2 * y + 1       // middle left
            };
        } else {
            yVertex = new int[]{
                    2 * y + 1,      //top left
                    2 * y + 1,      // top right
                    2 * y + 2,      // middle right
                    2 * y + 3,      // bottom right
                    2 * y + 3,      // bottom left
                    2 * y + 2       // middle left
            };
        }
        return yVertex;
    }

    @Override
    public Field[] getAdjacentFields(Vertex vertex) {
        if (vertex == null) {
            return null;
        }

        Field[] fields = new Field[3];

        int[] x = getAdjacentFieldsCoordinateX(vertex);
        int[] y = getAdjacentFieldsCoordinateY(vertex);

        fields[0] = getField(x[0], y[0]);
        fields[1] = getField(x[1], y[1]);
        fields[2] = getField(x[2], y[2]);

        return new Field[0];
    }

    public List<Field> getFields() {
        List<Field> returnFields = new LinkedList<Field>();
        for (Field[] fieldRow : fields) {
            for (Field field : fieldRow) {
                if (field != null) returnFields.add(field);
            }
        }
        return returnFields;
    }

    /**
     * This returns the x Coordinates of the adjacent fields in following order: top left and then clockwise.
     * WARNING!!! This method might return negative values!!!
     *
     * @param vertex The Vertex you want to know the adjacent fields of.
     * @return x Coordinates of the adjacent fields
     */
    private int[] getAdjacentFieldsCoordinateX(Vertex vertex) {
        int x = vertex.getX();
        int y = vertex.getY();

        int[] xFields = new int[3];

        xFields[0] = x - 1;
        xFields[1] = x;

        if (x % 2 == 0) {
            if (y % 2 == 0) {
                xFields[2] = x;
            } else {
                xFields[2] = x - 1;
            }

        } else {
            if (y % 2 == 0) {
                xFields[2] = x - 1;
            } else {
                xFields[2] = x;
            }
        }

        return xFields;
    }

    /**
     * This returns the y Coordinates of the adjacent fields in following order: top left and then clockwise.
     * WARNING!!! This method might return negative values!!!
     *
     * @param vertex vertex The Vertex you want to know the adjacent fields of.
     * @return y Coordinates of the adjacent fields
     */
    private int[] getAdjacentFieldsCoordinateY(Vertex vertex) {
        int x = vertex.getX();
        int y = vertex.getY();

        int[] yFields = new int[3];

        if (x % 2 == 0) {
            if (y % 2 == 0) {
                yFields[0] = (y - 2) / 2;
                yFields[1] = (y - 2) / 2;
                yFields[2] = y / 2;
            } else {
                yFields[0] = (y - 3) / 2;
                yFields[1] = (y - 1) / 2;
                yFields[2] = (y - 1) / 2;
            }

        } else {
            if (y % 2 == 0) {
                yFields[0] = (y - 2) / 2;
                yFields[1] = (y - 2) / 2;
                yFields[2] = y / 2;
            } else {
                yFields[0] = (y - 1) / 2;
                yFields[1] = (y - 3) / 2;
                yFields[2] = (y - 1) / 2;
            }
        }

        return yFields;
    }

    @Override
    public Vertex[] getNeighbouringVertices(Vertex vertex) {
        if (vertex == null) {
            return null;
        }

        Vertex[] vertices = new Vertex[3];

        int[] x = getNeighbouringVerticesCoordinateX(vertex);
        int[] y = getNeighbouringVerticesCoordinateY(vertex);

        vertices[0] = getVertex(x[0], y[0]);
        vertices[1] = getVertex(x[1], y[1]);
        vertices[2] = getVertex(x[2], y[2]);

        return new Vertex[0];
    }

    /**
     * This returns the x Coordinates of the neighbouring vertices in following order: top left and then clockwise.
     * WARNING!!! This method might return negative values!!!
     *
     * @param vertex The Vertex you want to know the neighbouring vertices of.
     * @return x Coordinates of the neighbouring vertices
     */
    private int[] getNeighbouringVerticesCoordinateX(Vertex vertex) {
        int x = vertex.getX();
        int y = vertex.getY();

        int[] xVertices = new int[3];

        //There are two different cases possible.
        //two vertices on left and one on right: x and y is even or both are uneven
        //one vertex on left and two on right: x or y is uneven and the other is even
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            xVertices[0] = x;
            xVertices[1] = x + 1;
            xVertices[2] = x;
        } else {
            xVertices[0] = x - 1;
            xVertices[1] = x;
            xVertices[2] = x;
        }

        return xVertices;
    }

    /**
     * This returns the y Coordinates of the neighbouring vertices in following order: top left and then clockwise.
     * WARNING!!! This method might return negative values!!!
     *
     * @param vertex The Vertex you want to know the neighbouring vertices of.
     * @return y Coordinates of the neighbouring vertices
     */
    private int[] getNeighbouringVerticesCoordinateY(Vertex vertex) {
        int x = vertex.getX();
        int y = vertex.getY();

        int[] yVertices = new int[3];

        //There are two different cases possible.
        //two vertices on left and one on right: x and y is even or both are uneven
        //one vertex on left and two on right: x or y is uneven and the other is even
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            yVertices[0] = y - 1;
            yVertices[1] = y;
            yVertices[2] = y + 1;
        } else {
            yVertices[0] = y;
            yVertices[1] = y - 1;
            yVertices[2] = y + 1;
        }

        return yVertices;
    }
}
