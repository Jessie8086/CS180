import java.io.Serializable;

/**
 * An exception class to clarify wrong ride error.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public class WrongRideException extends Exception implements Serializable {
    public WrongRideException(String message) {
        super(message);
    }
}
