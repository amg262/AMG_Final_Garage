
package amg_final_garage;



/**
 * 
 * Interface that has methods for different garage calculation strategies.
 * Each class that implements this will need to have these methods, because each one
 * HAS to output what the totaParkingFee is. I didn't think any other methods were 
 * necessary because we only need the total fee, not the perHour rate, minFee etc.
 * 
 * @author Andy Gunn
 */
public interface ParkingFeeCalculatingStrategy {
    
    /**
     * Passes in the hours, each strategy object must implement these because
     * its logical they will all need to use them
     * 
     * @param hours
     * @return totalParkingFee
     * @throws IllegalHoursException  
     */
    public abstract double getTotalParkingFee(double hours) throws IllegalHoursException ;
    
    /**
     * Sets the totalParkingFee if input by user
     * 
     * @param totalParkingFee
     * @throws IllegalArgumentException  
     */
    public abstract void setTotalParkingFee(double totalParkingFee) throws IllegalArgumentException;
}
