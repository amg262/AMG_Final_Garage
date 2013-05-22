
package amg_final_garage;


/**
 * 
 * The fee calculator for the Thrifty Garage Inc. client. The MIN_CHARGE,
 * PER_HOUR charges were specified in the requirements list.
 * Accepts hours, and outputs the totalParkingFee
 * using hours and specified rates.
 * 
 * @author Andy Gunn
 * 
 */
public class ThriftyFeeCalculator implements ParkingFeeCalculatingStrategy {


    private double totalParkingFee;
    private int minHours = 2;
    private double minCharge = 1.50;
    private double perHour= .75;
    private double maxCharge;
    
    
    /**
     * @param hours 
     */
    public ThriftyFeeCalculator(double hours) {
    }
    
    
    /**
     *
     */
    public ThriftyFeeCalculator(){
    }
    
  
    /**
     * Method from the interface that takes in the hours and assesses the fee
     * based on the hours, and the required criteria that was specified.
     * 
     * @param hours
     * @return totalParkingFee
     * @throws IllegalHoursException  
     */
    @Override
    public final double getTotalParkingFee(double hours) throws IllegalHoursException  {
       
        int iHours = (int) hours;
        
        if (hours < 0){
            throw new IllegalHoursException();
        }
        if ( iHours <= getMinHours()){
            totalParkingFee = getMinCharge();
        } else {
            totalParkingFee = getMinCharge() + ((iHours - getMinHours()) * getPerHour());
        }
        return totalParkingFee;
    }
    
  
    /**
     * Will set totalParkingFee if the number is greater than Zero AND it is
     * actually a number.
     * 
     * @param totalParkingFee
     * @throws IllegalArgumentException  
     */
    @Override
    public final void setTotalParkingFee(double totalParkingFee) throws IllegalArgumentException  {
        if (totalParkingFee < 0 || Double.isNaN(totalParkingFee)){
            throw new IllegalArgumentException();
        }
        this.totalParkingFee = totalParkingFee;
    }

    /**
     * Retrieves the minimum hours for this particular fee strategy, whether it is the
     * preset one, or they set it themselves.
     * 
     * @return the minHours
     */
    public int getMinHours() {
        return minHours;
    }

    /**
     * Will set minHours if the number is greater than Zero AND it is
     * actually a number.
     * 
     * @param minHours the minHours to set
     * @throws IllegalHoursException
     */
    public void setMinHours(int minHours) throws IllegalHoursException {
        if (minHours < 0 || Double.isNaN(minHours)){
            throw new IllegalHoursException();
        }
        this.minHours = minHours;
    }

    /**
     * Retrieves the maximum charge for this calculator, whether it is the
     * preset one, or they set it themselves.
     * 
     * @return the maxCharge
     */
    public double getMaxCharge() {
        return maxCharge;
    }

    /**
     * Checks if maxCharge is greater than zero, and actually a number. Would be
     * user to reset the max charge to a different number.
     * 
     * @param maxCharge the maxCharge to set
     */
    public void setMaxCharge(double maxCharge) {
        if (maxCharge < 0 || Double.isNaN(maxCharge)){
            throw new IllegalArgumentException();
        }
        this.maxCharge = maxCharge;
    }

    /**
     * Retrieves the rate the perHour the garage charges each customer.
     * 
     * @return the perHour
     */
    public double getPerHour() {
        return perHour;
    }

    /**
     * Checks if perHour is greater than zero, and actually a number. Would be
     * user to reset the perHour to a different number.
     * 
     * @param perHour the perHour to set
     */
    public void setPerHour(double perHour) {
        if (perHour < 0 || Double.isNaN(perHour)){
            throw new IllegalArgumentException();
        }
        this.perHour = perHour;
    }

    /**
     * Retrieves minCharge for this calculator.
     * 
     * @return the minCharge
     */
    public double getMinCharge() {
        return minCharge;
    }

    /**
     * Checks if minCharge is greater than zero, and actually a number. Would be
     * user to reset the perHour to a different number.
     * 
     * @param minCharge the minCharge to set
     */
    public void setMinCharge(double minCharge) {
        if (minCharge < 0 || Double.isNaN(minCharge)){
            throw new IllegalArgumentException();
        }
        this.minCharge = minCharge;
    }

    @Override
    public String toString() {
        return "ThriftyFeeCalculator{" + "totalParkingFee=" + totalParkingFee
                + ", minHours=" + minHours + ", minCharge=" + minCharge
                + ", perHour=" + perHour + ", maxCharge=" + maxCharge + '}';
    }
}
