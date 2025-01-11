import java.io.Serializable;

/**
 * An exception class to clarify space full error.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 16, 2024
 */
public class SpaceFullException extends Exception implements Serializable {
    public SpaceFullException(String message) {
        super(message);
    }
}
