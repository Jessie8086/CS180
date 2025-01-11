import java.util.Objects;

/**
 * A rollercoaster class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public class Rollercoaster extends Ride {
    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated) {
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Rollercoaster)) {
            return false;
        }
        Rollercoaster rc = (Rollercoaster) o;
        return this.getMaxRiders() == rc.getMaxRiders() && this.getMinHeight() == rc.getMinHeight()
                && Objects.equals(this.getName(), rc.getName()) && Objects.equals(this.getColor(), rc.getColor())
                && this.isSimulated() == rc.isSimulated();

    }

    public boolean isSimulated() {
        return simulated;
    }

    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + '\n' +
                "Color: " + super.getColor() + '\n' +
                "MinHeight: " + super.getMinHeight() + " inches\n" +
                "MaxRiders: " + super.getMaxRiders() + '\n' +
                "Simulated: " + this.isSimulated();
    }
}
