/**
 * Represents a single face of a cube in three-dimensional Cartesian space.
 * A face is composed of two triangles that share two vertices and have identical surface normals.
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Project 02
 *
 * @author Jiaxun Li
 * @version February 2024
 */
public class Face {
    private Triangle[] mesh;
    private UnitVector surfaceNormal;

    /**
     * Constructs a face with two triangles.
     * If triangle one and two share two common vertices and their surface normals are equal,
     * they are set as the mesh of the face. Otherwise, an invalid face is created.
     */
    public Face(Triangle one, Triangle two) {
        Point[] verticesOne = one.getVertices();
        Point[] verticesTwo = two.getVertices();

        int commonVerticesCount = 0;
        for (Point vertexOne : verticesOne) {
            for (Point vertexTwo : verticesTwo) {
                if (vertexOne.compareTo(vertexTwo)) {
                    commonVerticesCount++;
                }
            }
        }

        boolean snEquals = one.getSurfaceNormal().compareTo(two.getSurfaceNormal());

        if (commonVerticesCount >= 2 && snEquals) {
            mesh = new Triangle[]{one, two};
            surfaceNormal = one.getSurfaceNormal();
        } else {
            mesh = new Triangle[]{new Triangle(), new Triangle()};
            surfaceNormal = new UnitVector();
        }
    }

    /**
     * Constructs an invalid face with two invalid triangles and an invalid surface normal.
     */
    public Face() {
        mesh = new Triangle[]{new Triangle(), new Triangle()};
        surfaceNormal = new UnitVector();
    }

    public Triangle[] getMesh() {
        return mesh;
    }

    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }


    public void flipSurfaceNormal() {
        for (Triangle triangle : mesh) {
            triangle.flipSurfaceNormal();
        }
        surfaceNormal.flipVector();
    }

    /**
     * Compares this face with another face.
     * Faces are considered equal if their triangles share the same vertices and surface normals.
     */
    public boolean compareTo(Face face) {
        for (int i = 0; i < mesh.length; i++) {
            if (!mesh[i].compareTo(face.mesh[i])) {
                return false;
            }
        }

        return surfaceNormal.compareTo(face.surfaceNormal);
    }

    /**
     * Checks if this face is similar to another face.
     * Two faces are considered similar if they share the same surface normal or any of their triangles are similar.
     */
    public boolean isSimilar(Face face) {
        if (surfaceNormal.compareTo(face.surfaceNormal)) {
            return true;
        }

        for (Triangle thisTriangle : mesh) {
            for (Triangle otherTriangle : face.mesh) {
                if (thisTriangle.isSimilar(otherTriangle)) {
                    return true;
                }
            }
        }

        return false;
    }

    //Returns the string representation of this face.
    public String toString() {
        StringBuilder sb = new StringBuilder("{F");
        for (Triangle t : mesh) {
            if (t.toString().equals("[InvalidTriangle]")) {
                return "{InvalidFace}";
            }

            String str = t.toString();
            str = str.substring(0, str.indexOf("; N"));
            sb.append(str + "]").append(" ");
        }
        sb.append("N").append(surfaceNormal.toString()).append("}");
        return sb.toString();
    }
}
