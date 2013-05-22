

package amg_final_garage;

import java.util.HashSet;
import java.util.Set;

/**
 * TicketVendingMachine instantiates the receipt and ticket. Ticket gets passed
 * the parkingFee that is calculated based on the hours, and which garage it is 
 * parked in. 
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class Ticket {

    private double fee;

    /**
     *
     * @param parkingFee
     */
    public Ticket(double parkingFee) {
        this.fee = parkingFee;
    }

    
    /**
     * Gets the fee thats attached to the Ticket object, based on
     * how many hours, and which garage it is parked in.
     * 
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    
    /**
     * Manually set the fee for the Ticket object, throws exception if 
     * its not valid.
     * 
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        if (fee < 0 || Double.isNaN(fee)){
            throw new IllegalArgumentException();
        }
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Ticket{" + "fee=" + fee + '}';
    }
    
    
}
