package Core.Command;

/**
 *
 * @author Holger Szuesz <hszuesz@live.com>
 */
public class RestrictionException extends Exception {

    /**
     * Creates a new instance of <code>RestrictionException</code> without
     * detail message.
     */
    public RestrictionException() {
    }

    /**
     * Constructs an instance of <code>RestrictionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RestrictionException(String msg) {
        super(msg);
    }
}
