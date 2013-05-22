
package amg_final_garage;

/**
 * Custom exception that is thrown when the garageId is deemed to be
 * incorrectly entered, or doesn't exist in the company file.
 * 
 * @author Andy
 */
public class IllegalGarageIdException extends Exception {

    //No magic numbers
    private static final String ERR = "Invalid: Garage Id";

    /**
     *
     */
    public IllegalGarageIdException() {
        super(ERR);
    }

    /**
     *
     * @param ERR
     */
    public IllegalGarageIdException(String ERR) {
        super(ERR);
    }

    /**
     *
     * @param ERR
     * @param thrwbl
     */
    public IllegalGarageIdException(String ERR, Throwable thrwbl) {
        super(ERR, thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public IllegalGarageIdException(Throwable thrwbl) {
        super(thrwbl);
    }
 
}
