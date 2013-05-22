
package amg_final_garage;

/**
 * 
 * This is a fee calculator that can variable depending on what the client chooses. The
 * specifications can be changed via the constructor, or getter and setter methods.
 * This calculator's sole purpose is for flexibility when it comes down to choosing
 * and assessing the way one would go about charging fees.
 * 
 * @author Andy
 * 
 */
public class VariableFeeCalculator implements ParkingFeeCalculatingStrategy  {


    private double totalParkingFee;
    private int minHours;
    private double minCharge;
    private double perHour;
    private double maxCharge;

    /**
     * @param minHours
     * @param minCharge
     * @param perHour
     * @param maxCharge 
     */
    public VariableFeeCalculator(int minHours, double minCharge, double perHour, double maxCharge) {
        this.minHours = minHours;
        this.minCharge = minCharge;
        this.perHour = perHour;
        this.maxCharge = maxCharge;
    }
    
    /**
     *
     */
    public VariableFeeCalculator(){
    }
    
    
    /**
     * Casts the double hours into an integer to, in essence, round the number down.
     * Assesses how long the car has been parked, and executes through proper if 
     * statement, and returns the total parking fee after all math has been done.
     * 
     * @param hours
     * @return totalParkingFee
     * @throws IllegalHoursException  
     */
    @Override
    public double getTotalParkingFee(double hours) throws IllegalHoursException { //Should be able to be changed because its variable
        
        
        int iHours = (int) hours;
        
        if (hours < 0){
            throw new IllegalHoursException();
        }
        
        if ( iHours <= minHours){
            totalParkingFee = minCharge;
        } else if ( iHours > minHours && totalParkingFee < maxCharge ) {
            totalParkingFee = minCharge + ((iHours - minHours) * perHour); 
        } else { 
            totalParkingFee = maxCharge;
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
    public final void setTotalParkingFee(double totalParkingFee) throws IllegalArgumentException {
        
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
        return "VariableFeeCalculator{" + "totalParkingFee=" + totalParkingFee + 
                ", minHours=" + minHours + ", minCharge=" + minCharge + ", perHour="
                + perHour + ", maxCharge=" + maxCharge + '}';
    }
    
    
}
