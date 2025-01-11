import java.util.ArrayList;

/**
 * A Park interface.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public interface Park {
    void addRide(Ride ride) throws WrongRideException;

    void close();

    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException;

    double getAdmissionCost();

    double getLand();

    String getName();

    ArrayList<Ride> getRides();

    boolean[] getSeasons();

    boolean isIndoor();

    boolean isOutdoor();

    void removeRide(Ride ride);

    void setAdmissionCost(double admissionCost);

    void setName(String name);

    void setSeasons(boolean[] seasons);


}
