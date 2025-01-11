/**
 * Represents a triangle in three-dimensional Cartesian space.
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Project 02
 *
 * @author Jiaxun Li
 * @version February 2024
 */

public class Triangle {
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private UnitVector surfaceNormal;

    /**
     * Constructs a triangle with the specified vertices.
     * Calculates the surface normal based on the given vertices.
     */
    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;

        UnitVector aToB = new UnitVector(vertexA, vertexB);
        UnitVector aToC = new UnitVector(vertexA, vertexC);
        this.surfaceNormal = aToB.crossProduct(aToC);
    }

    public Triangle() {
        this.vertexA = new Point();
        this.vertexB = new Point();
        this.vertexC = new Point();
        this.surfaceNormal = new UnitVector();
    }

    public Point getVertexA() {
        return vertexA;
    }
    public Point getVertexB() {
        return vertexB;
    }
    public Point getVertexC() {
        return vertexC;
    }
    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }

    //Gets an array containing the vertices of the triangle.
    public Point[] getVertices() {
        Point[] vertices = new Point[3];
        vertices[0] = vertexA;
        vertices[1] = vertexB;
        vertices[2] = vertexC;
        return vertices;
    }

    //Flips the direction of the surface normal of the triangle.
    public void flipSurfaceNormal() {
        surfaceNormal.flipVector();
    }

    /**
     * Compares this triangle with another triangle.
     * Triangles are considered equal if their vertices and surface normals are equal.
     */
    public boolean compareTo(Triangle triangle) {
        Point[] thisVertices = this.getVertices();
        Point[] otherVertices = triangle.getVertices();
        for (int i = 0; i < thisVertices.length; i++) {
            if (!thisVertices[i].compareTo(otherVertices[i])) {
                return false;
            }
        }

        if (!this.surfaceNormal.compareTo(triangle.surfaceNormal)) {
            return false;
        }

        return true;
    }

    /**
     * Checks if this triangle is similar to another triangle.
     * Two triangles are considered similar if they share the same vertices (in any order)
     * or have the same surface normal.
     */
    public boolean isSimilar(Triangle triangle) {
        Point[] thisVertices = this.getVertices();
        Point[] otherVertices = triangle.getVertices();
        boolean sameVertices = false;
        for (int i = 0; i < thisVertices.length; i++) {
            if (thisVertices[i].compareTo(otherVertices[0]) &&
                    thisVertices[(i + 1) % thisVertices.length].compareTo(otherVertices[1]) &&
                    thisVertices[(i + 2) % thisVertices.length].compareTo(otherVertices[2])) {
                sameVertices = true;
                break;
            }
        }

        boolean sameNormal = this.surfaceNormal.compareTo(triangle.surfaceNormal);
        return sameVertices || sameNormal;
    }

    //Returns the string representation of the triangle.
    public String toString() {
        Point[] vertices = this.getVertices();
        if (!isValidTriangle(vertices) || surfaceNormal.compareTo(new UnitVector())) {
            return "[InvalidTriangle]";
        }

        String vertexStr = "[" + "A" + vertices[0] + "; " + "B" + vertices[1] + "; " + "C" + vertices[2] +
                "; N" + surfaceNormal.toString() + "]";

        return vertexStr;
    }

    //Helper method to check if the triangle is valid
    private boolean isValidTriangle(Point[] vertices) {
        return vertices.length == 3 && !vertices[0].compareTo(vertices[1])
                && !vertices[1].compareTo(vertices[2]) && !vertices[0].compareTo(vertices[2]);
    }
}
