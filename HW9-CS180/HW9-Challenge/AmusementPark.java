import java.util.ArrayList;

/**
 * An amusement park class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public class AmusementPark implements Park {
    private double admissionCost;
    private boolean arcade;
    private boolean bowling;
    private boolean indoor;
    private double land;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;

    public AmusementPark(String name, double admissionCost, double land,
                         ArrayList<Ride> rides, boolean indoor,
                         boolean outdoor, boolean arcade, boolean bowling,
                         boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    public void addRide(Ride ride) throws WrongRideException {
        if (ride instanceof Rollercoaster) {
            rides.add(ride);
        } else {
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");
        }
    }

    public void modifyRide(Ride ride, String newName, String newColor,
                           int newMinHeight, int newMaxRiders, boolean newSimulated) {

        for (Ride rideToUpdate : rides) {
            if (rideToUpdate.equals(ride)) {
                ride = rideToUpdate;
                ride.setName(newName);
                ride.setColor(newColor);
                ride.setMinHeight(newMinHeight);
                ride.setMaxRiders(newMaxRiders);
                Rollercoaster rideChild = (Rollercoaster) ride;
                rideChild.setSimulated(newSimulated);
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

    public void close() {
        this.name = "";
        this.admissionCost = 0;
        this.land = 0;
        this.rides = null;
        this.seasons = null;
        this.indoor = false;
        this.outdoor = false;
        this.arcade = false;
        this.bowling = false;
    }

    public void enlarge(double addedLand, double maxLand,
                        boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException {

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

    public boolean isArcade() {
        return arcade;
    }

    public boolean isBowling() {
        return bowling;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public boolean isOutdoor() {
        return outdoor;
    }


    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }

    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }
}