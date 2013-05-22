
package amg_final_garage;

/**
 * 
 * Implements OutputStrategy interface. If this is chose for output, it
 * prints out to the console.
 * 
 * @author Andy Gunn
 */
public class ConsoleOutputStrategy implements OutputStrategy {
    
    /**
     * Uses console to output receiptOutput
     * 
     * @param receiptOutput 
     */
    @Override
    public final void outputTransaction(String receiptOutput) {
        
        System.out.println(receiptOutput);
    }
    
    
}
