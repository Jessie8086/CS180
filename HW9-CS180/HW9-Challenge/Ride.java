import java.util.Objects;

/**
 * A ride class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public class Ride {
    private String color;
    private int maxRiders;
    private int minHeight;
    private String name;

    public Ride() {
        this.name = "";
        this.color = "";
        this.minHeight = 0;
        this.maxRiders = 0;
    }

    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    //重写equals方法，使得该方法能比较两个同类对象的属性值而不是地址值。原始的equals方法是比较的地址值。
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Ride)) {
            return false;
        }
        Ride ride = (Ride) o;
        return maxRiders == ride.maxRiders && minHeight == ride.minHeight
                && Objects.equals(name, ride.name) && Objects.equals(color, ride.color);
    }

    public String getColor() {
        return color;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Color: " + color + '\n' +
                "MinHeight: " + minHeight + " inches\n" +
                "MaxRiders: " + maxRiders;
    }
}
