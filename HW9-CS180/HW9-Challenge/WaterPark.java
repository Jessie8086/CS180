import java.util.ArrayList;

/**
 * A water park class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public class WaterPark implements Park {
    private double admissionCost;
    private boolean indoor;
    private double land;
    private boolean lazyRiver;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;
    private boolean wavePool;

    public WaterPark(String name, double admissionCost, double land,
                     ArrayList<Ride> rides, boolean indoor, boolean outdoor,
                     boolean lazyRiver, boolean wavePool, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;
    }

    public void addRide(Ride ride) throws WrongRideException {

        if (ride instanceof Waterslide) {
            rides.add(ride);
        } else {
            throw new WrongRideException("A waterpark can only have waterslide rides!");
        }


    }

    public void close() {
        this.name = "";
        this.admissionCost = 0;
        this.land = 0;
        this.rides = null;
        this.seasons = null;
        this.indoor = false;
        this.outdoor = false;
        this.lazyRiver = false;
        this.wavePool = false;
    }

    public void enlarge(double addedLand, double maxLand, boolean addedIndoor,
                        boolean addedOutdoor) throws SpaceFullException {

        if (addedLand + land <= maxLand) {
            land = land + addedLand;
        } else {
            throw new SpaceFullException("There is no more land to use for this park!");
        }

        if (addedIndoor && !indoor) {
            this.indoor = true;
        }
        if (addedOutdoor && !outdoor) {
            this.outdoor = true;
        }
    }

    public double getAdmissionCost() {
        return admissionCost;
    }

    public double getLand() {
        return land;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public boolean[] getSeasons() {
        return seasons;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public boolean isLazyRiver() {
        return lazyRiver;
    }

    public boolean isOutdoor() {
        return outdoor;
    }

    public boolean isWavePool() {
        return wavePool;
    }

    public void modifyRide(Ride ride, String newName, String newColor,
                           int newMinHeight, int newMaxRiders, double newSplashDepth) {
        for (Ride rideToUpdate : rides) {
            if (rideToUpdate.equals(ride)) {
                ride = rideToUpdate;
                ride.setName(newName);
                ride.setColor(newColor);
                ride.setMinHeight(newMinHeight);
                ride.setMaxRiders(newMaxRiders);
                Waterslide rideChild = (Waterslide) ride;
                rideChild.setSplashDepth(newSplashDepth);
            }
        }
    }

    public void removeRide(Ride ride) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                rides.remove(i);
                i--;
            }
        }
    }

    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    public void setLazyRiver(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }

    public void setWavePool(boolean wavePool) {
        this.wavePool = wavePool;
    }

}
