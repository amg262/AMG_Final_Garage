
package amg_final_garage;

import java.io.*;

/**
 * 
 * Implements OutputStrategy interface. When this is used it outputs the
 * information to a .doc file in the project directory.
 * 
 * @author Andy Gunn
 */
public class FileOutputStrategy implements OutputStrategy {
    
    /**
     * Outputs receiptOutput to a file
     * 
     * @param receiptOutput 
     */
    @Override
    public final void outputTransaction(String receiptOutput) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("default_receipt.txt", true));
            
            out.write(receiptOutput);
            out.close();
                      
        }catch (IOException e){
    }
}
    
    
}