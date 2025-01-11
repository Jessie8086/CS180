import java.util.Objects;

/**
 * A waterslide class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public class Waterslide extends Ride {
    private double splashDepth;

    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth) {
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Waterslide)) {
            return false;
        }
        Waterslide ws = (Waterslide) o;
        return this.getMaxRiders() == ws.getMaxRiders() && this.getMinHeight() == ws.getMinHeight()
                && Objects.equals(this.getName(), ws.getName()) && Objects.equals(this.getColor(), ws.getColor())
                && this.getSplashDepth() == ws.getSplashDepth();
    }

    public double getSplashDepth() {
        return splashDepth;
    }

    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + '\n' +
                "Color: " + super.getColor() + '\n' +
                "MinHeight: " + super.getMinHeight() + " inches\n" +
                "MaxRiders: " + super.getMaxRiders() + '\n' +
                "SplashDepth: " + this.getSplashDepth() + " feet";
    }
}
