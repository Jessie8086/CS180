import java.text.DecimalFormat;

/**
 * Represents a unit vector in three-dimensional Cartesian space.
 * A unit vector has a magnitude of 1 and is often used to represent direction.
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Project 02
 *
 * @author Jiaxun Li
 * @version February 2024
 */
public class UnitVector {
    private double i;
    private double j;
    private double k;

    /**
     * Constructs a unit vector with the specified components.
     * If the magnitude of the vector is not equal to 1, it scales the vector to have a magnitude of 1.
     */
    public UnitVector(double i, double j, double k) {
        double magnitude = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2));
        if (Math.abs(magnitude - 1.0) > 0.0001) {
            if (Math.abs(magnitude) < 0.0001) {
                this.i = 0.0;
                this.j = 0.0;
                this.k = 0.0;
            } else {
                this.i = i / magnitude;
                this.j = j / magnitude;
                this.k = k / magnitude;
            }
        } else {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    //Constructs a unit vector from two points by calculating the vector between them.
    public UnitVector(Point start, Point end) {
        this(
                end.getX() - start.getX(),
                end.getY() - start.getY(),
                end.getZ() - start.getZ()
        );
    }
    
    public UnitVector() {
        this.i = 0.000;
        this.j = 0.000;
        this.k = 0.000;
    }


    public double getI() {
        return i;
    }

    public double getJ() {
        return j;
    }

    public double getK() {
        return k;
    }

    //Flips the direction of the unit vector.
    public void flipVector() {
        this.i = -this.i;
        this.j = -this.j;
        this.k = -this.k;
    }

    //Compares this unit vector to another unit vector.
    public boolean compareTo(UnitVector vector) {
        double val = 0.0001;
        return Math.abs(this.i - vector.getI()) <= val &&
                Math.abs(this.j - vector.getJ()) <= val &&
                Math.abs(this.k - vector.getK()) <= val;
    }

    //Computes the cross product of this unit vector and another unit vector.
    public UnitVector crossProduct(UnitVector b) {
        double newI = this.j * b.getK() - this.k * b.getJ();
        if (Math.abs(newI) == 0.0) {
            newI = 0.0;
        }
        double newJ = this.k * b.getI() - this.i * b.getK();
        if (Math.abs(newJ) == 0.0) {
            newJ = 0.0;
        }
        double newK = this.i * b.getJ() - this.j * b.getI();
        if (Math.abs(newK) == 0.0) {
            newK = 0.0;
        }

        return new UnitVector(newI, newJ, newK);
    }

    //Returns the string representation of this unit vector.
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000");
        if (Math.abs(i) < 0.0001 && Math.abs(j) < 0.0001 && Math.abs(k) < 0.0001) {
            return "<InvalidUnitVector>";
        } else {
            return "<" + df.format(i) + "i, " + df.format(j) + "j, " + df.format(k) + "k>";
        }
    }
}
