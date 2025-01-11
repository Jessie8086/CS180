import java.text.DecimalFormat;

/**
 * Represents a point in three-dimensional Cartesian space.
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Project 02
 *
 * @author Jiaxun Li
 * @version February 2024
 */

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point() {
        this(0.0, 0.0, 0.0);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Compares this point with another point.
     * Points are considered equal if their coordinates are within a tolerance value.
     */
    public boolean compareTo(Point point) {
        double val = 0.0001;
        return Math.abs(this.x - point.getX()) <= val &&
                Math.abs(this.y - point.getY()) <= val &&
                Math.abs(this.z - point.getZ()) <= val;
    }

    /**
     * Returns the string representation of the point.
     * The format is (x, y, z) with three decimal places.
     */

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000");
        return "(x" + df.format(x) + ", y" + df.format(y) + ", z" + df.format(z) + ")";
    }
}
