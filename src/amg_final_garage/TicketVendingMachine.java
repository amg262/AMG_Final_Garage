
package amg_final_garage;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * 
 * This class has the methods that basically kick-start the program. It creates
 * the Receipt object in the startNewTrans() method, adds the hoursToGarage, and hours
 * to the total. This class also provides validation on anything passed through, and if 
 * anything is invalid, it will give feedback, and stop the program.
 * 
 * This class also has the framework for flexible output. It allows the 5 optional output
 * methods when changed in the StartUp class.
 * 
 * @author Andy Gunn
 */
public class TicketVendingMachine {

    private Receipt receipt;
    private OutputStrategy receiptOutput;
    private OutputStrategy totalsOutput;
    private OutputStrategy output;


    /**
     * @param output 
     */
    public TicketVendingMachine(OutputStrategy output){
        this.output = output;
    }
    
    
    /**
     *
     */
    public TicketVendingMachine(){ 
    }
    
    
    
    /**
     * Creates Ticket and Receipt objects. Must be called before each transaction
     * otherwise nothing will happen because the necessary objects for later 
     * operates wouldn't have been initialized.
     */
    public final void startNewTransaction(){
        receipt = new Receipt();
    }
    
    
    /**
     * Adds the hours to the garage, which is needed to return the amount owed,
     * because the garage contains the fee strategy. If garage doesn't equal null,
     * (which means it was found in the company file, and therefore must exist) it will
     * called the receipt method to add the hours to the garage. If it comes back as null,
     * it will throw and exception for illegalId.
     * 
     * @param hours
     * @param garageId
     * @throws IllegalGarageIdException 
     * @throws IllegalHoursException  
     */
    public final void addHoursToGarage(double hours, String garageId)
            throws IllegalGarageIdException, IllegalHoursException{
        Garage garage = receipt.getGarage(garageId);
 
        if(garage == null) {
          throw new IllegalGarageIdException();  
        }
        if (Double.isNaN(hours)){
            throw new IllegalHoursException();
        } else {
        receipt.addHoursToGarage(hours, garageId);
        }
    }

    
    /**
     * Method for getting total hours from the "surface" of the program. In short,
     * it counts every hour input and holds it. This method calls the Receipt.getAccrued
     * to retrieve the totalhours. If hours is NaN, or violates anything else, it will 
     * throw exception.
     * 
     * @param totalHours
     * @throws IllegalHoursException  
     */
    public final void addHoursToTotal(double totalHours) throws IllegalHoursException{
        if (totalHours < 0){
            throw new IllegalHoursException();
        } else {
        receipt.getAccruedHours(totalHours);
        }
    }
    
    
    /**
     * Method calls the receiptOutput method in Receipt Class, and uses a Strategy
     * object to decide which output is should utilize.
     * 
     * @param hours
     * @param receiptOutput
     * @throws IllegalGarageIdException
     * @throws IllegalHoursException  
     */
    public final void printReceipt(double hours, OutputStrategy receiptOutput) throws
            IllegalGarageIdException, IllegalHoursException{
        if (hours < 0){
            throw new IllegalHoursException();
        }
        
        receiptOutput.outputTransaction(receipt.getReceipt(hours));
    }
    
    
    /**
     * Method calls the totalsOutput method in Receipt Class, and uses a Strategy
     * object to decide which output is should utilize.
     * 
     * @param totalHours
     * @param totalsOutput
     * @throws IllegalGarageIdException
     * @throws IllegalHoursException
     * @throws IOException  
     */
    public final void printTotals(double totalHours, OutputStrategy totalsOutput) throws IllegalGarageIdException,
            IllegalHoursException, IOException{
        
        if (totalHours < 0){
            throw new IllegalHoursException();
        } 
        
        totalsOutput.outputTransaction(receipt.getGarageTotals(totalHours));
    }

    @Override
    public String toString() {
        return "TicketVendingMachine{" + "receipt=" + receipt
                + ", receiptOutput=" + receiptOutput + ", totalsOutput="
                + totalsOutput + ", output=" + output + '}';
    }
    
    
}
