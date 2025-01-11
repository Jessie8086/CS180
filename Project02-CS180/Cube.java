import java.util.ArrayList;
import java.util.List;

/**
 * Represents a cube in three-dimensional Cartesian space.
 * A cube is comprised of six faces (squares), where each face shares an edge with four other faces,
 * and faces that do not share an edge have opposite surface normal vectors.
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Project 02
 *
 * @author Jiaxun Li
 * @version February 2024
 */
public class Cube {
    private Face[] mesh;

    /**
     * Constructs a cube with the specified faces.
     * Validates that each face shares exactly one edge with each of four other faces,
     * no face is the same as another face, and each surface normal of opposed faces
     * is pointing in an opposite direction.
     * If any of the validation fails, sets each face in the mesh to be an invalid face.
     */
    public Cube(Face one,
                Face two,
                Face three,
                Face four,
                Face five,
                Face six) {
        mesh = new Face[]{one, two, three, four, five, six};

        // Confirming no face is the same as another face
        for (int i = 0; i < mesh.length; i++) {
            for (int j = i + 1; j < mesh.length; j++) {
                if (mesh[i].compareTo(mesh[j])) {
                    invalidateFaces();
                    return;
                }
            }
        }

        // Confirming each face shares exactly one edge with each of 4 other faces
        for (int i = 0; i < mesh.length; i++) {
            int edgeCount = 0;
            for (int j = 0; j < mesh.length; j++) {
                if (i != j && shareOneEdge(mesh[i], mesh[j])) {
                    edgeCount++;
                }
            }
            if (edgeCount != 4) {
                invalidateFaces();
                return;
            }
        }

        // Confirming each surfaceNormal of opposed Faces is pointing in an opposite direction
        for (int i = 0; i < mesh.length; i++) {
            for (int j = i + 1; j < mesh.length; j++) {
                if (!mesh[i].isSimilar(mesh[j])) {
                    if (!oppositeDirection(mesh[i].getSurfaceNormal(), mesh[j].getSurfaceNormal())) {
                        invalidateFaces();
                        return;
                    }
                }
            }
        }
    }

    /**
     * Constructs an invalid cube with all faces set to invalid faces.
     */
    public Cube() {
        invalidateFaces();
    }

    private void invalidateFaces() {
        mesh = new Face[]{new Face(), new Face(), new Face(), new Face(), new Face(), new Face()};
    }

    private List<Point> getPointsOfFace(Face face) {
        List<Point> points = new ArrayList<>();
        for (Triangle t : face.getMesh()) {
            Point[] pts = t.getVertices();
            for (Point p : pts) {
                boolean exist = false;
                for (Point a : points) {
                    if (p.compareTo(a)) {
                        exist = true;
                        break;
                    }
                }

                if (!exist) {
                    points.add(p);
                }
            }
        }

        return points; //shoule 4
    }

    private boolean shareOneEdge(Face face1, Face face2) {
        List<Point> vertices1 = getPointsOfFace(face1);
        List<Point> vertices2 = getPointsOfFace(face2);

        int sharedVerticesCount = 0;
        for (Point vertex1 : vertices1) {
            for (Point vertex2 : vertices2) {
                if (vertex1.compareTo(vertex2)) {
                    sharedVerticesCount++;
                }
            }
        }

        return sharedVerticesCount == 2;
    }

    private boolean oppositeDirection(UnitVector normal1, UnitVector normal2) {
        double dotProduct = normal1.getI() * normal2.getI() + normal1.getJ() * normal2.getJ()
                + normal1.getK() * normal2.getK();
        return Math.abs(dotProduct + 1) < 0.0001;
    }

    /**
     * Returns the array of faces representing this cube.
     * return the array of faces.
     */
    public Face[] getMesh() {
        return mesh;
    }

    /**
     * Returns the string representation of this cube.
     * return the string representation.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("|C");
        for (Face f : mesh) {
            if (!f.toString().equals("{InvalidFace}")) {
                return "|InvalidCube|";
            }
            sb.append(f.toString());
        }
        sb.append("|");
        return sb.toString();
    }
}
