
package amg_final_garage;

/**
 * Custom exception for the Hours field when entered. If the hours is incorrect
 * in anyway, whether too long, short, or not a Number, it will throw this custom
 * exception.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class IllegalHoursException extends Exception {

    //No magic numbers
    private static final String ERR = "Invalid: Hours";

    /**
     *
     */
    public IllegalHoursException() {
        super(ERR);
    }

    /**
     *
     * @param ERR
     */
    public IllegalHoursException(String ERR) {
        super(ERR);
    }

    /**
     *
     * @param ERR
     * @param thrwbl
     */
    public IllegalHoursException(String ERR, Throwable thrwbl) {
        super(ERR, thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public IllegalHoursException(Throwable thrwbl) {
        super(thrwbl);
    }
}
