
package amg_final_garage;


/**
 * 
 * Interface for different output strategies for increased flexibility 
 * for receipt output. 5 different options (OS = OutputStrategy)
 * 1)- ConsoleOS 2)- GuiOS 3)- FileOS 4)- ConsoleFileOS 5)- GuiFileOS
 * 
 * @author Andy Gunn
 */
public interface OutputStrategy {
    
    /**
     * Method will be called by each separate output strategy and will do
     * the outputting
     * 
     * @param receiptOutput 
     */
    public abstract void outputTransaction(String receiptOutput);
}
