
package amg_final_garage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * Implements OutputStrategy interface. When this is used, it not only prints the 
 * information out to the console, but also writes the output into a .doc file
 * in project directory.
 * 
 * 
 * @author Andy Gunn
 * 
 */
public class ConsoleFileOutputStrategy implements OutputStrategy {
    
    /**
     * Uses console and File to output receiptOutput
     * 
     * @param receiptOutput 
     */
    @Override
    public final void outputTransaction(String receiptOutput) {

        
        try  {
            BufferedWriter out = new BufferedWriter(new FileWriter("console_receipt.txt", true));
            
            out.write(receiptOutput);
            System.out.println(receiptOutput);
            out.close();

        } catch (IOException e){

    }
    }
    
}
